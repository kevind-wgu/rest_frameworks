package edu.wgu.ai.quickstart;

import io.activej.inject.Injector;
import junit.framework.TestCase;
import org.junit.Test;

public class QuickStartTest {
    @Test
    public void test() {
        Injector injector = Injector.of(new ConfigModule(), new ServiceModule());
        Service service = injector.getInstance(Service.class);
        service.process();

    }
}