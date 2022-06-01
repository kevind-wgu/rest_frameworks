package edu.wgu.ai.cocoa;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class HCLogger {
    private List<String> logs = new ArrayList<>();

    @Inject
    public HCLogger() {
    }

    public void log(String msg) {
        System.out.println("add log - " + this.hashCode() + " - " + msg);
        logs.add(msg);
    }

    public List<String> logs() {
        System.out.println("get logs - " + this.hashCode());
        return new ArrayList<>(logs);
    }
}
