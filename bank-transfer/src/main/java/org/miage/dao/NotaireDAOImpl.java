package org.miage.dao;
import org.miage.exception.NotaireNotFoundException;
import org.miage.model.Notaire;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.miage.exception.NotaireNotFoundException;

@ApplicationScoped
public class NotaireDAOImpl implements NotaireDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;


    @Override
    public Notaire createNewNotaire(String fname, String lname, String email, String phone) {
        Notaire notaire = new Notaire(fname, lname, email, phone);
        em.persist(notaire);
        return notaire;
    }
}