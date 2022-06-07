package test.javalin_guice;

import com.google.inject.Injector;
import io.javalin.apibuilder.ApiBuilder;

public class GreetingResourceRoutes {
    public static void routes(Injector injector) {
        ApiBuilder.get("/hello", ctx -> {
            GreetingResource instance = injector.getInstance(GreetingResource.class);
            ctx.status(200);
            ctx.result(instance.hello());
        });
    }
}
