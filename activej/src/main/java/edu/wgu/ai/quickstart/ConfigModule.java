package edu.wgu.ai.quickstart;

import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;

import java.net.InetSocketAddress;

public class ConfigModule extends AbstractModule {
    @Provides
    InetSocketAddress inetSocketAddress() {
        return new InetSocketAddress(1234);
    }

    @Provides
    String dbName() {
        return "exampleDB";
    }
}
