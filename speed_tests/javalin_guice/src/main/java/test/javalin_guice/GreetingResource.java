package test.javalin_guice;


import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class GreetingResource {
    private final Provider<GreetingsService> service;

    @Inject
    public GreetingResource(Provider<GreetingsService> service) {
        this.service = service;
    }

    public String hello() {
        return service.get().hello();
    }
}