package edu.wgu.ai.quickstart;

import io.activej.inject.annotation.Inject;

import java.net.InetSocketAddress;

public class DataSource {
    private final InetSocketAddress address;
    private final String dbName;

    @Inject
    public DataSource(InetSocketAddress address, String dbName) {
        this.address = address;
        this.dbName = dbName;
    }

    public String queryData() {
        System.out.printf("Querying %s:%s for data%n", address, dbName);
        return "data";
    }
}
