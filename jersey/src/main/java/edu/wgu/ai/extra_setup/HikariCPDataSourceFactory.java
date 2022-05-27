package edu.wgu.ai.extra_setup;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.Factory;

public class HikariCPDataSourceFactory implements Factory<HikariDataSource> {
    @Inject
    public HikariCPDataSourceFactory() {
    }

    @Override
    public HikariDataSource provide() {
        System.out.println("PROVIDE DataSource");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:10001/quarkus_app");
        config.setUsername("testuser");
        config.setPassword("test1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }

    @Override
    public void dispose(HikariDataSource dataSource) {
        System.out.println("DISPOSE DATASOURCE");
        dataSource.close();
    }
}
