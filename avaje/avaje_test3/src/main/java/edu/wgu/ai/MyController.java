package edu.wgu.ai;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import io.javalin.http.Context;
import jakarta.inject.Inject;

import javax.validation.Valid;

@Valid
@Controller
@Path("/path")
public class MyController {
    private final MyReadService myReadService;
    private final Context contex;

    @Inject
    public MyController(MyReadService myReadService, Context contex) {
        this.myReadService = myReadService;
        this.contex = contex;
    }

    @Post("/{id}")
    public void create(MyObj obj) {
    }

    @Get("/{id}")
    public MyObj get(int id) {
        return myReadService.get(id).orElse(null);
    }
}
