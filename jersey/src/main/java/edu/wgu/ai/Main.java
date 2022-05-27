package edu.wgu.ai;

import edu.wgu.ai.extra_setup.HikariCPDataSourceFactory;
import edu.wgu.ai.extra_setup.JdbiFactory;
import jakarta.inject.Singleton;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.jdbi.v3.core.Jdbi;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.wgu.ai package
        final ResourceConfig rc = new ResourceConfig(JacksonFeature.class).packages("edu.wgu.ai")
                .property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true)
                .property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);

        rc.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(HikariCPDataSourceFactory.class).to(DataSource.class).in(Singleton.class);
                bindFactory(JdbiFactory.class).to(Jdbi.class).in(Singleton.class);
                bind(JobService.class).to(JobService.class).in(RequestScoped.class);

            }
        });
        ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc, locator);
//        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

