package test.kdodge;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Executable;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Application {
    private static final String ROOT_DIR = "/Users/kevin.dodge/github/testit/rest_frameworks/speed_tests/";
    private static final String START_CMD = "java -jar " + ROOT_DIR;
    private static final Map<String, String> APPS = Map.of(
            "javalin", START_CMD + "javalin_guice/target/test-javalin.jar",
            "dropwizard", START_CMD + "dropwizard/target/test-1.0-SNAPSHOT.jar server " + ROOT_DIR + "dropwizard/application.yml",
            "micronaut", START_CMD + "micronaut/target/micronaut-0.1.jar",
            "quarkus", START_CMD + "quarkus/target/quarkus-1.0.0-SNAPSHOT-runner.jar"
    );


    public static void main(final String[] args) throws Exception {
        System.out.println("Begin");
        long start = System.currentTimeMillis();
        long end = 0;
        if (args.length < 1) {
            System.out.println("INVALID APP, possible apps - " + APPS.keySet());
            return;
        }

        String runit = APPS.get(args[0]);
        if (runit == null) {
            System.out.println("INVALID APP, possible apps - " + APPS.keySet());
            return;
        }

        AtomicBoolean quit = new AtomicBoolean(false);
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Exec Start - " + runit);
                Process exec = Runtime.getRuntime().exec(runit);
                System.out.println("Exec Start 2");

                while (!quit.get() && exec.isAlive()) {
                    Thread.sleep(100);
                }
                if (!quit.get()) {
                    System.out.println("Unexpected Ending - " + IOUtils.toString(exec.getErrorStream(), StandardCharsets.UTF_8));
                }
                System.out.println("Exec End ");
                exec.destroy();
            } catch (InterruptedException | IOException e) {
                System.out.println("Exec Error");
                e.printStackTrace();
            }
        });
        thread.start();

        System.out.println("Starting to Query");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:8080/hello")).GET().build();
        while (true) {
            if (!thread.isAlive()) {
                System.out.println("Thread Died, quitting");
                return;
            }
            try {
                HttpResponse<String> res = client.send(get, HttpResponse.BodyHandlers.ofString());
                if (res.statusCode() == 200) {
                    end = System.currentTimeMillis();
                    System.out.println("Success- " + res.statusCode() + " - " + res.body());
                    break;
                }
            }
            catch (ConnectException e) {
                // ignore
            }
            Thread.sleep(1);
            System.out.print(".");
        }

        quit.set(true);
        System.out.println("Total Time - " + (end - start));
        Thread.sleep(100);
        System.out.println("Quitting");
    }
}
