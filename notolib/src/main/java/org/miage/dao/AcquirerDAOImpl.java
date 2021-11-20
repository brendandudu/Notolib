package org.miage.dao;

import org.miage.model.Acquirer;

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
    public Collection<Acquirer> findAcquirerByAvailablity(LocalDate date) {
        return null; //TODO requete compliqué
    }

    @Override
    public Acquirer createNewAcquirer(String fname, String lname, String email, String phone) {
        Acquirer a = new Acquirer(fname, lname, email, phone);
        em.persist(a);
        return a;
    }
}
