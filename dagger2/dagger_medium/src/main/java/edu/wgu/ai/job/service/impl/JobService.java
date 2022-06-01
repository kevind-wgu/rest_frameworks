package edu.wgu.ai.job.service.impl;

import edu.wgu.ai.job.model.Job;
import edu.wgu.ai.job.service.CRUDService;

import javax.inject.Inject;
import java.util.Optional;

public class JobService implements CRUDService<Job, Integer> {

    @Inject
    public JobService() {
    }

    @Override
    public Integer create(Job obj) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Job> get(Integer id) {
        return Optional.empty();
    }

    @Override
    public String getTypeName() {
        return null;
    }

    @Override
    public void update(Job obj) {

    }
}
