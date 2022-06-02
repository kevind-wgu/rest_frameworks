package edu.wgu.ai.service;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.RequestScoped;
import io.javalin.http.Context;

public class JavalinCtxModule extends AbstractModule  {
    private static final ThreadLocal<Context> localContext = new ThreadLocal<>();

    public static void setup(Context ctx) {
        System.out.println("setup ctx");
        localContext.set(ctx);
    }

    public static void teardown(Context ctx) {
        System.out.println("teardown ctx");
        localContext.remove();
    }

    @Provides
    @RequestScoped
    public Context context() {
        return localContext.get();
    }
}
