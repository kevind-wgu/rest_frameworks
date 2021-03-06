package edu.wgu.ai.service.impl;

import com.google.inject.servlet.RequestScoped;
import edu.wgu.ai.model.Job;
import edu.wgu.ai.model.JobSearch;
import edu.wgu.ai.service.CRUDService;
import edu.wgu.ai.service.ListService;
import io.javalin.http.Context;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestScoped
public class JobController {
    private final ListService<Job, JobSearch> listService;
    private final CRUDService<Job, Integer> crudService;
    private final HttpServletRequest request;
    private final Context context;

    @Inject
    public JobController(ListService<Job, JobSearch> listService, CRUDService<Job, Integer> crudService, HttpServletRequest request, Context context) {
        this.listService = listService;
        this.crudService = crudService;
        this.request = request;
        this.context = context;
    }

    public List<Job> get(JobSearch search) {
        return listService.list(search);
    }

    public Job get(Integer id) {
        return crudService.getRequired(id);
    }

    public int create(Job job) {
        return crudService.create(job);
    }
}
