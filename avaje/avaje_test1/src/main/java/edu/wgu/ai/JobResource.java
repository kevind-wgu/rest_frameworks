package edu.wgu.ai;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.MediaType;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.avaje.http.api.Put;
import io.javalin.http.Context;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.List;

@Valid
@Controller
@Path("/job")
public class JobResource {
    private final JobService service;
    private final Context context;

    @Inject
    public JobResource(JobService service, Context context) {
        this.service = service;
        this.context = context;
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public List<Job> list() {
        return service.list();
    }

    @Post("")
    public int create(Job hello) {
        return service.create(hello);
    }

    @Get("/{id}")
    public Job get(int id) {
        return service.get(id);
    }

    @Put("/{id}")
    public void update(int id, Job hello) {
        hello.setId(id);
        service.update(hello);
    }
}