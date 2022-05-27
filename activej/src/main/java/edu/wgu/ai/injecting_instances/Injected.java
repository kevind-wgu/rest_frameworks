package edu.wgu.ai.injecting_instances;

import io.activej.inject.annotation.Inject;

@Inject
public class Injected {
    @Inject
    String value;

    @Inject
    int id;
}
