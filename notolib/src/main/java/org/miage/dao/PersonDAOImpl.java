package org.miage.dao;

import org.miage.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
@PersonQualifier
public class PersonDAOImpl implements PersonDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Person findByEmail(String email) {
        return (Person) em.createQuery("Select p from Person p where p.email=:email").setParameter("email", email).getSingleResult();
    }

    @Override
    public Person createNew(String fname, String lname, String email, String phone) {
        return null;
    }
}
