package test.javalin_guice;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    Javalin app = Main.app(); // inject any dependencies you might have

    @Test
    public void test_hello1() {
        JavalinTest.test(app, (server, client) -> {
            assertThat(client.get("/hello").code()).isEqualTo(200);
            assertThat(client.get("/hello").body().string()).isEqualTo("Hello from Javalin and Guice");
        });
    }

    @Test
    public void test_hello2() {
        JavalinTest.test(app, (server, client) -> {
            assertThat(client.get("/hello").code()).isEqualTo(200);
            assertThat(client.get("/hello").body().string()).isEqualTo("Hello from Javalin and Guice");
        });
    }
}