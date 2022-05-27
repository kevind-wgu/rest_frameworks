package org.acme;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.enterprise.context.Dependent;
import javax.inject.Singleton;
import javax.sql.DataSource;
import javax.ws.rs.Produces;

@Dependent
public class JdbiProvider {

    @Produces
    @Singleton
    public Jdbi jdbi(DataSource ds) {
        return Jdbi.create(ds)
                .installPlugin(new SqlObjectPlugin());
    }

}
