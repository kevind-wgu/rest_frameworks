package edu.wgu.ai.injecting_instances;

import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;

public class MessageModule extends AbstractModule {
    @Provides
    String message() {
        return "hello";
    }
}