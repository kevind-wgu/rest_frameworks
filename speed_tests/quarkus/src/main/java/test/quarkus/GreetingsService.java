package test.quarkus;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GreetingsService {
    private final String hellotype;

    public GreetingsService(@ConfigProperty(name="hellotype") String helloType) {
        this.hellotype = helloType;
    }

    public String hello() {
        return "Hello from " + hellotype;
    }
}
