package org.miage.dao;

import org.miage.model.Notary;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class NotaryDAOImpl implements NotaryDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Notary findNotaryByEmail(String email) {
        return null;
    }

    @Override
    public Notary createNewNotary(String fname, String lname, String email, String phone) {
        Notary a = new Notary(fname, lname, email, phone);
        em.persist(a);
        return a;
    }
}
