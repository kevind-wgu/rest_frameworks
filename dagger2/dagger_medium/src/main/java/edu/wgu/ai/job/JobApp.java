package edu.wgu.ai.job;

import dagger.Component;
import edu.wgu.ai.job.model.Job;
import edu.wgu.ai.job.service.ReadService;
import edu.wgu.ai.job.service.impl.JobModule;

import javax.inject.Singleton;

public class JobApp {
    @Singleton
    @Component(
            modules = {
                    JobModule.class,
            },
            dependencies = {}
    )
    public interface ServiceComponent {
        ReadService<Job, Integer> jobService();
    }

    public static void main(String[] args) {
        DaggerJobApp_ServiceComponent.builder().build().jobService().get(1);
        DaggerJobApp_ServiceComponent.builder().build().jobService().get(1);
    }
}
