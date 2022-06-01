package edu.wgu.ai.service.impl;

import edu.wgu.ai.model.Job;
import edu.wgu.ai.model.JobSearch;
import edu.wgu.ai.service.CRUDService;
import edu.wgu.ai.service.ListService;
import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.List;

@Valid
@Controller
@Path("/job")
public class JobController {
    private final ListService<Job, JobSearch> listService;
    private final CRUDService<Job, Integer> crudService;

    @Inject
    public JobController(ListService<Job, JobSearch> listService, CRUDService<Job, Integer> crudService) {
        this.listService = listService;
        this.crudService = crudService;
    }

    @Get
    public List<Job> get(JobSearch search) {
        return listService.list(search);
    }

    @Get("/{id}")
    public Job get(Integer id) {
        return crudService.getRequired(id);
    }

    @Post("/{id}")
    public int create(Job job) {
        return crudService.create(job);
    }
}
