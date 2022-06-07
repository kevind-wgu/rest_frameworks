package test.mironaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class HelloWorldTest {
    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void test() {
        String value = client.toBlocking().retrieve(HttpRequest.GET("/hello"), String.class);
        assertEquals(value, "Hello from KDodge Micronaut");
    }
}
