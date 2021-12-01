package org.miage.dao;

import org.miage.model.Acquirer;
import org.miage.model.Notary;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class AcquirerDAOImpl implements PersonDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Acquirer findByEmail(String email) {
        return null; //TODO
    }

    @Override
    public Acquirer createNew(String fname, String lname, String email, String phone) {
        Acquirer a = new Acquirer(fname, lname, email, phone);
        em.persist(a);
        return a;
    }
}
