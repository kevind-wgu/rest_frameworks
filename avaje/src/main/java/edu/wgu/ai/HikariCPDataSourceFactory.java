package edu.wgu.ai;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.avaje.inject.PostConstruct;
import io.avaje.inject.PreDestroy;
import jakarta.inject.Provider;
import jakarta.inject.Singleton;
import org.jdbi.v3.core.Jdbi;

import javax.sql.DataSource;

//@Singleton
@Factory
public class HikariCPDataSourceFactory { // implements Provider<HikariDataSource> {
//    private HikariDataSource dataSource;

//    @PostConstruct
//    public void construct() {
    @Bean
    public DataSource ds() {
        System.out.println("CREATE DataSource");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:10001/quarkus_app");
        config.setUsername("testuser");
        config.setPassword("test1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }

//    @PreDestroy
//    public void dispose() {
//        if (dataSource != null) {
//            System.out.println("DISPOSE DATASOURCE");
//            dataSource.close();
//            dataSource = null;
//        }
//        else {
//            System.out.println("DISPOSE DATASOURCE NULL");
//        }
//    }
//
//    @Override
//    public HikariDataSource get() {
//        System.out.println("PROVIDE DATASOURCE");
//        return dataSource;
//    }
//
}
