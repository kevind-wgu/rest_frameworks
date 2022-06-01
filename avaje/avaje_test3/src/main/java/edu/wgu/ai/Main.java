package edu.wgu.ai;

import io.avaje.http.api.Validator;
import io.avaje.http.api.WebRoutes;
import io.avaje.inject.BeanScope;
import io.avaje.inject.InjectModule;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@InjectModule(name = "app", requires = Validator.class)
@OpenAPIDefinition(info = @Info(title = "Example service", description = "Example Javalin controllers with Java and Maven"))
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        start(8080);
    }

    public static Javalin start(int port) {

        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;
            config.addStaticFiles("public", Location.CLASSPATH);
            config.accessManager((handler, ctx, permittedRoles) -> {
                log.debug("allow access ...");
                handler.handle(ctx);
            });
        });

        // All WebRoutes / Controllers ... from DI Context
        BeanScope beanScope = BeanScope.builder().build();

        List<WebRoutes> webRoutes = beanScope.list(WebRoutes.class);
        app.routes(() -> webRoutes.forEach(WebRoutes::registerRoutes));
//
        app.start(port);
        return app;
    }
}