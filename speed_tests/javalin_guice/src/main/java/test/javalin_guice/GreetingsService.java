package test.javalin_guice;

import com.google.inject.servlet.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
public class GreetingsService {
    private final String hellotype;

    @Inject
    public GreetingsService(@Named("hellotype") String helloType) {
        this.hellotype = helloType;
    }

    public String hello() {
        return "Hello from " + hellotype;
    }
}
