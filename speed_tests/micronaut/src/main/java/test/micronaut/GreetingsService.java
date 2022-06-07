package test.micronaut;

import io.micronaut.context.annotation.Value;
import io.micronaut.runtime.http.scope.RequestScope;

@RequestScope
public class GreetingsService {
    private final String hellotype;

    public GreetingsService(@Value("${hellotype}") String helloType) {
        this.hellotype = helloType;
    }

    public String hello() {
        return "Hello from " + hellotype;
    }
}
