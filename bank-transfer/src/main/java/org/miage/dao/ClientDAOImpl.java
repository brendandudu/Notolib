package org.miage.dao;
import org.miage.model.Client;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}