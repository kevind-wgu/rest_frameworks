package edu.wgu.ai.service.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import edu.wgu.ai.model.Job;
import edu.wgu.ai.model.JobSearch;
import edu.wgu.ai.service.CRUDService;
import edu.wgu.ai.service.ListService;
import edu.wgu.ai.service.ReadService;

public class JobModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<ReadService<Job, Integer>>(){}).to(JobService.class);
        bind(new TypeLiteral<ListService<Job, JobSearch>>(){}).to(JobService.class);
    }

    @Provides
    CRUDService<Job, Integer> readService(JobService jobService) {
        return jobService;
    }
}
