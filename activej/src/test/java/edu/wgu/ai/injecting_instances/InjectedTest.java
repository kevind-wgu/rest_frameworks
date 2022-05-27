package edu.wgu.ai.injecting_instances;

import io.activej.inject.Injector;
import io.activej.inject.module.ModuleBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class InjectedTest {
    @Test
    public void testIt() {
        Injector injector = Injector.of(
                new MessageModule(),
                new IdModule(),
                ModuleBuilder.create()
                        .bindInstanceInjector(Injected.class)
                        .build());
    }

    @Test
    public void test2() {
        Injector injector = Injector.of(
                new MessageModule(),
                new IdModule(),
                ModuleBuilder.create()
                        .bind(Injected.class)
                        .build());
    }

}