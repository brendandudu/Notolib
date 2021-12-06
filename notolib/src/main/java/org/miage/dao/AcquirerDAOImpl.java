package org.miage.dao;

import org.miage.model.Acquirer;
import org.miage.model.Notary;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@ApplicationScoped
@AcquirerQualifier
public class AcquirerDAOImpl extends PersonDAOImpl {

    @PersistenceContext
    EntityManager em;

    @Override
    public Acquirer findByEmail(String email) {
        return (Acquirer) em.createQuery("Select a from Acquirer a where a.email=:email").setParameter("email", email).getSingleResult();
    }

    @Override
    public Acquirer createNew(String fname, String lname, String email, String phone) {
        Acquirer a = new Acquirer(fname, lname, email, phone);
        em.persist(a);
        return a;
    }
}
