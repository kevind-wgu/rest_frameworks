package test.dropwizard;

import com.google.inject.servlet.RequestScoped;
import ru.vyarus.dropwizard.guice.module.yaml.bind.Config;

import javax.inject.Inject;

@RequestScoped
public class GreetingsService {
    private final String hellotype;

    @Inject
    public GreetingsService(@Config("hellotype") String helloType) {
        this.hellotype = helloType;
    }

    public String hello() {
        return "Hello from " + hellotype;
    }
}
