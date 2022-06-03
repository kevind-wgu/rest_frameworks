package edu.wgu.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.ServletModule;
import edu.wgu.ai.model.Job;
import edu.wgu.ai.model.JobActivityStatus;
import edu.wgu.ai.model.JobSearch;
import edu.wgu.ai.service.JavalinCtxModule;
import edu.wgu.ai.service.ValidateModule;
import edu.wgu.ai.service.impl.JobController;
import edu.wgu.ai.service.impl.JobModule;
import io.javalin.Javalin;
import io.javalin.core.validation.BodyValidator;
import io.javalin.http.staticfiles.Location;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        start(8080);
    }

    public static Javalin start(int port) {
        Injector injector = Guice.createInjector(
                new ServletModule(),
                new JobModule(),
                new JavalinCtxModule(),
                new ValidateModule()
        );

        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;
            config.addStaticFiles("public", Location.CLASSPATH);
            config.accessManager((handler, ctx, permittedRoles) -> {
                log.debug("allow access ...");
                handler.handle(ctx);
            });
            config.configureServletContextHandler(handler -> {
                handler.addFilter(GuiceFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
            });
        });
        app.exception(BodyValidationException.class, (e, ctx) -> {
            ctx.status(400);
            List<Map<String, String>> collect = e.getValidate().stream()
                    .map(v -> Map.of("msg", v.getMessage(), "path", v.getPropertyPath().toString(), "badValue", v.getInvalidValue().toString()))
                    .collect(Collectors.toList());
            ctx.json(collect);
        });
        app.before(JavalinCtxModule::setup);
        app.after(JavalinCtxModule::teardown);
        app.get("/job", ctx -> {
            String status = ctx.queryParam("status");
            JobActivityStatus activityStatus = status != null ? JobActivityStatus.valueOf(status) : null;
            JobSearch jobSearch = JobSearch.builder().status(activityStatus).build();
            JobController instance = injector.getInstance(JobController.class);
            ctx.status(200);
            ctx.json(instance.get(jobSearch));
        });
        app.post("/job", ctx -> {
            BodyValidator<Job> jobBodyValidator = ctx.bodyValidator(Job.class);

            Job job = jobBodyValidator.get();
            Validator validator = injector.getInstance(Validator.class);
            Set<ConstraintViolation<Job>> validate = validator.validate(job);
            if (!validate.isEmpty()) {
                throw new BodyValidationException(validate);
            }

            JobController instance = injector.getInstance(JobController.class);
            ctx.status(201);
            ctx.json(instance.create(job));
        });
        app.get("/job/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            JobController instance = injector.getInstance(JobController.class);
            ctx.status(200);
            ctx.json(instance.get(id));
        });

        app.start(port);
        return app;
    }
}