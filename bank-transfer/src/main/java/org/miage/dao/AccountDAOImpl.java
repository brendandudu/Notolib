package org.miage.dao;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.model.Account;
import org.miage.model.Client;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    @PersistenceContext(name = "mysql")
    EntityManager em;

    @ConfigProperty(name = "org.miage.idBank")
    String idBank;


    @Override
    @Transactional
    public Account findAccountByClientId(int client_id) {
        Account a = (Account) em.createQuery("Select a from Account a where a.client.id=:client_id").setParameter("client_id", client_id).getSingleResult();
        return a;
    }

    @Override
    public String findRibByAccountId(int id) {
        return idBank + id;
    }

    @Override
    public void createLoanBalance(Account account, double amount) {
        account.addLoanBalance(amount);
        em.merge(account);
    }

    @Override
    public void addBalance(Account account, double amount) {
        account.addBalance(amount);
        em.merge(account);
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
        Account c = (Account) em.createQuery("Select a from Account a where a.client.email=:email").setParameter("email", email).getSingleResult();
        return c;
    }


}