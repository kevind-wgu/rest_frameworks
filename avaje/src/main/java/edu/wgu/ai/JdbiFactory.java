package edu.wgu.ai;

import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;

@Factory
public class JdbiFactory {
    private final DataSource dataSource;

    @Inject
    public JdbiFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public Jdbi jdbi() {
        System.out.println("PROVIDE JDBI");
        return Jdbi.create(dataSource).installPlugin(new SqlObjectPlugin());
    }

}
