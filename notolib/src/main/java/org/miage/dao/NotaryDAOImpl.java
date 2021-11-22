package org.miage.dao;

import org.miage.model.Acquirer;
import org.miage.model.Notary;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Collection;

@ApplicationScoped
public class NotaryDAOImpl implements PersonDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Notary findByEmail(String email) {
        return null;
    } //TODO

    @Override
    public Notary createNew(String fname, String lname, String email, String phone) {
        Notary a = new Notary(fname, lname, email, phone);
        em.persist(a);
        return a;
    }
}
