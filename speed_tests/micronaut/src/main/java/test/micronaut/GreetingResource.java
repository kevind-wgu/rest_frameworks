package test.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/hello")
public class GreetingResource {
    private final GreetingsService service;

    public GreetingResource(GreetingsService service) {
        this.service = service;
    }

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return service.hello();
    }
}