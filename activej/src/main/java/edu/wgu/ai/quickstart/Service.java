package edu.wgu.ai.quickstart;

public class Service {
    private final DataSource dataSource;

    public Service(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void process() {
        String data = dataSource.queryData();
        System.out.printf("Processing data: '%s'%n", data);
    }
}
