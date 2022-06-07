package test.javalin_guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.util.Properties;

public class ConfigModule extends AbstractModule {
    @Override
    protected void configure() {
        Properties props = new Properties();
        props.setProperty("hellotype", "Javalin and Guice");
        Names.bindProperties(binder(), props);
    }
}
