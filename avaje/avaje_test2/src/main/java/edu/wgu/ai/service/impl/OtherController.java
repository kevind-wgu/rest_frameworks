package edu.wgu.ai.service.impl;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;
import io.javalin.http.Context;
import jakarta.inject.Inject;

@Controller
@Path("/other")
public class OtherController {
    private final Context context;
    private final JobService jobService;

    @Inject
    public OtherController(Context context, JobService jobService) {
        this.context = context;
        this.jobService = jobService;
    }

    @Get("/get")
    public String getIt() {
        return "";
    }
}
