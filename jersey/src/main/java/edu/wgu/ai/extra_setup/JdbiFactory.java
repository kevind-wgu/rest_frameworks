package edu.wgu.ai.extra_setup;

import jakarta.inject.Inject;
import org.glassfish.hk2.api.Factory;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;

public class JdbiFactory implements Factory<Jdbi> {
    private final DataSource dataSource;

    @Inject
    public JdbiFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Jdbi provide() {
        System.out.println("PROVIDE JDBI");
        return Jdbi.create(dataSource).installPlugin(new SqlObjectPlugin());
    }

    @Override
    public void dispose(Jdbi jdbi) {

    }
}
