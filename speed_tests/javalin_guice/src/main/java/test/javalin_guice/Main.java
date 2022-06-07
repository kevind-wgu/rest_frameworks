package test.javalin_guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.ServletModule;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Javalin app = app();
        app.start(8080);
    }

    public static Javalin app() {
        Injector injector = Guice.createInjector(
                new ServletModule(),
                new ConfigModule()
        );

        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;
            config.configureServletContextHandler(handler -> {
                handler.addFilter(GuiceFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
            });
        });
        app.routes(() -> {
            GreetingResourceRoutes.routes(injector);
        });

        return app;
    }
}