package org.miage.dao;
import org.miage.model.Account;
import org.miage.model.Client;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ClientDAOImpl implements ClientDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;


    @Override
    public Client createNewClient(String fname, String lname, String email, String phone) {
        Client client = new Client(fname, lname, email, phone);
        em.persist(client);
        return client;
    }
    @Override
    @Transactional
    public int findIdByEmail(String email) {
        return (int) em.createQuery("Select c.id from Client c where c.email=:email").setParameter("email", email).getSingleResult();
    }
}