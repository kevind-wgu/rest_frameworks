package org.acme;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/job")
public class JobResource {
    private final JobService service;
    private final Validator validator;

    @Inject
    public JobResource(JobService service, Validator validator) {
        this.service = service;
        this.validator = validator;
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
    public int create(@Valid Job hello) {
        return service.create(hello);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Job get(int id) {
        return service.get(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(int id, @Valid Job hello) {
        hello.setId(id);
        service.update(hello);
    }
}