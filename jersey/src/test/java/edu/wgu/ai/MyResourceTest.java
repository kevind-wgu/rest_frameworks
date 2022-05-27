package edu.wgu.ai;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("[{\"id\":1,\"name\":\"name\",\"vendorCode\":\"code\",\"status\":\"INACTIVE\",\"cron\":null,\"cronHumanReadable\":null,\"contactEmail\":null,\"createdDate\":{\"nano\":774758000,\"epochSecond\":1653325901},\"updatedDate\":{\"nano\":774758000,\"epochSecond\":1653325901}}]", responseMsg);

        responseMsg = target.path("myresource").request().get(String.class);
        responseMsg = target.path("myresource").request().get(String.class);
    }
}
