package org.acme;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class JobService {
    private final HelloDao dao;

    @Inject
    public JobService(Jdbi jdbi) {
        this.dao = jdbi.onDemand(HelloDao.class);
    }

    public List<Job> list() {
        return dao.list();
    }

    public Job get(int id) {
        return dao.get(id).orElseThrow(() -> new RuntimeException("INVALID"));
    }

    public int create(Job hello) {
        return dao.insert(hello);
    }

    public void update(Job hello) {
        dao.update(hello);
    }

    interface HelloDao {
        String TABLE_NAME = "job";

        @SqlQuery("SELECT * FROM " + TABLE_NAME)
        @RegisterBeanMapper(Job.class)
        List<Job> list();

        @SqlUpdate("INSERT INTO " + TABLE_NAME + "(name, vendor_code, status, cron, contact_emails, updated_date) VALUES (:name, :vendorCode, :status, :cron, :contactEmails, now())")
        @GetGeneratedKeys
        int insert(@BindBean Job greeting);

        @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
        @RegisterBeanMapper(Job.class)
        Optional<Job> get(Integer id);

        @SqlUpdate("UPDATE " + TABLE_NAME + " set name = :name, vendor_code= :vendorCode, status = :status, cron = :cron, contact_emails = :contactEmails, updated_date = now() where id = :id")
        void update(@BindBean Job obj);
    }
}
