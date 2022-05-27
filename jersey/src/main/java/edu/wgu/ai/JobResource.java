package edu.wgu.ai;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/job")
public class JobResource {

    private final JobService service;

    @Inject
    public JobResource(JobService service) {
        this.service = service;
    }

    @GET
    @Path("/txt")
    @Produces(MediaType.TEXT_PLAIN)
    public String txt() {
        return "HELLO";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Job> list() {
        return service.list();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int create( Job hello) {
        return service.create(hello);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Job get(@PathParam("id") int id) {
        return service.get(id);
    }

    // Validation not working
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") int id, @Valid Job hello) {
        hello.setId(id);
        service.update(hello);
    }
}
