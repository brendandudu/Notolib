package org.miage.dao;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;
import org.miage.model.Client;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    @PersistenceContext(name = "mysql")
    EntityManager em;

    @ConfigProperty(name = "org.miage.idBank")
    String idBank;

    @Inject
    ClientDAO clientDAO;

    @Override
    @Transactional
    public Account findAccountByClientId(int client_id) {
        Account a = (Account) em.createQuery("Select a from Account a where a.client.id=:client_id").setParameter("client_id", client_id).getSingleResult();
        return a;
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
    public String findRibByEmail(String email)  throws AccountNotFoundException {
        try {
            int account_id = (int) em.createQuery("Select a.id from Account a where a.client.email=:email").setParameter("email", email).getSingleResult();
            return idBank + account_id;
        }catch(NoResultException e){
            throw new AccountNotFoundException();
        }

    }

    @Override
    public Account findAccountbyRib(String rib) {
        int account_id = Integer.parseInt(rib.substring(6));
        return em.find(Account.class, account_id);
    }
}