package edu.wgu.ai.job.service.impl;

import dagger.Binds;
import dagger.Module;
import edu.wgu.ai.job.model.Job;
import edu.wgu.ai.job.service.CRUDService;
import edu.wgu.ai.job.service.ReadService;

@Module
public abstract class JobModule {
    @Binds
    abstract CRUDService<Job, Integer> jobService(JobService service);

    @Binds
    abstract ReadService<Job, Integer> jobReadService(JobService service);
}
