package org.miage.dao;

import org.miage.model.Acquirer;
import org.miage.model.Notary;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Collection;

@ApplicationScoped
public class AcquirerDAOImpl implements AcquirerDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Notary findAcquirerByEmail(String email) {
        return null;
    }

    @Override
    public Acquirer createNewAcquirer(String fname, String lname, String email, String phone) {
        Acquirer a = new Acquirer(fname, lname, email, phone);
        em.persist(a);
        return a;
    }
}
