package org.miage.dao;

import org.miage.model.Acquiror;
import org.miage.model.Bank;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AcquirorDAOImpl implements AcquirorDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Acquiror createNewAcquiror(String fname, String lname, String email, String phone, Bank bank) {
        Acquiror c = new Acquiror(fname, lname, email, phone, bank);
        em.persist(c);
        return c;
    }
}
