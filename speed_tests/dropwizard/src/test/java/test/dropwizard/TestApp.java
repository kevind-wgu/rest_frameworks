package test.dropwizard;

import org.junit.jupiter.api.Test;
import ru.vyarus.dropwizard.guice.test.ClientSupport;
import ru.vyarus.dropwizard.guice.test.jupiter.TestDropwizardApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestDropwizardApp(value = TestApplication.class, randomPorts = true, config="application.yml")
public class TestApp {
    @Test
    public void testMyService(ClientSupport client) {
        String response = client.targetMain("hello")
                .request()
                .buildGet()
                .invoke()
                .readEntity(String.class);
        assertEquals("Hello from Dropwizard", response);
    }
}
