package org.miage.dao;
import org.miage.model.Bank;
import org.miage.model.Notaire;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class NotaireDAOImpl {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //@Override
    @Transactional
    public Notaire createNewClient(String fname, String lname, String email, String phone, Bank bank){
        Notaire notaire = new Notaire(fname, lname, email, phone, bank);
        em.persist(notaire);
        return notaire;
    }
}