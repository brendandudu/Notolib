package org.miage.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ClientDAOImpl {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //@Override
    @Transactional
    public Client createNewClient(String fname, String lname, String email, String phone, Bank bank){
        Client client = new Client(fname, lname, email, phone, bank);
        em.persist(client);
        return client;
    }
}