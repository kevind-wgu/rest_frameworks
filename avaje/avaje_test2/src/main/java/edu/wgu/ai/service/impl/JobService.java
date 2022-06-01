package edu.wgu.ai.service.impl;

import edu.wgu.ai.model.Job;
import edu.wgu.ai.model.JobSearch;
import edu.wgu.ai.service.CRUDService;
import edu.wgu.ai.service.ListService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class JobService implements CRUDService<Job, Integer>, ListService<Job, JobSearch> {

    @Inject
    public JobService() {
    }

    @Override
    public List<Job> list(JobSearch search) {
        return List.of(getJob());
    }

    @Override
    public Optional<Job> get(Integer id) {
        return Optional.of(getJob());
    }


    @Override
    public Integer create(Job obj) {
        return 1;
    }

    @Override
    public void update(Job obj) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public String getTypeName() {
        return "Job";
    }

    private Job getJob() {
        return Job.builder()
                .id(1)
                .name("NAME")
                .vendorCode("CODE")
                .build();
    }
}
