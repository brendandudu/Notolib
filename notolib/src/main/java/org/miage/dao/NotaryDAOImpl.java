package org.miage.dao;

import org.miage.model.Acquirer;
import org.miage.model.Notary;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Collection;

@ApplicationScoped
@NotaryQualifier
public class NotaryDAOImpl extends PersonDAOImpl {

    @PersistenceContext
    EntityManager em;

    @Override
    public Notary findByEmail(String email) {
        Notary n = (Notary) em.createQuery("Select n from Notary n where n.email=:email").setParameter("email",email).getSingleResult();
        return n;
    }

    @Override
    public Notary createNew(String fname, String lname, String email, String phone) {
        Notary a = new Notary(fname, lname, email, phone);
        em.persist(a);
        return a;
    }
}
