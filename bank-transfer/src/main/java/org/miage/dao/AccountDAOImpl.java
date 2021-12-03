package org.miage.dao;
import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.context.ApplicationScoped;
import org.miage.model.Account;
import org.miage.model.Client;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    @PersistenceContext(name = "mysql")
    EntityManager em;


    @Override
    @Transactional
    public Account findAccountByClientId(int client_id) {
        Account a = (Account) em.createQuery("Select a from Account a where a.client_id.id=:client_id").setParameter("client_id", client_id).getSingleResult();
        return a;
    }

    @Override
    @Transactional
    public Account createNewAccount(double balance, Client client) {
        Account c = new Account(balance, client);
        em.persist(c);
        return c;
    }

    @Override
    @Transactional
    public Account findRibByEmail(String email) {
        Account c = (Account) em.createQuery("Select a from Account a where a.client_id.email=:email").setParameter("email", email).getSingleResult();
        return c;
    }

}