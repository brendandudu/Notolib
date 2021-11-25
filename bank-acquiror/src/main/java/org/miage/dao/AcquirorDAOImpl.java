package org.miage.dao;

import org.miage.model.Acquiror;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AcquirorDAOImpl implements AcquirorDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Acquiror createNewAcquiror(String fname, String lname, String email, String phone) {
        Acquiror c = new Acquiror(fname, lname, email, phone);
        em.persist(c);
        return c;
    }
}
