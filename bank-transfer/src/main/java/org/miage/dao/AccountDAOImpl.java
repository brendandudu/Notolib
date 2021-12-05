package org.miage.dao;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;
import org.miage.model.Client;
import org.miage.service.AccountServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
    @Transactional
    public void withdrawLoanBalance(int accountId, double amount) {
        Account account = em.find(Account.class, accountId);
        account.setLoanBalance(account.getLoanBalance() - amount);
    }

    @Override
    @Transactional
    public void depositLoanBalance(int accountId, double amount) {
        Account account = em.find(Account.class, accountId);
        account.setLoanBalance(account.getLoanBalance() + amount);
    }

    @Override
    @Transactional
    public void withdrawBalance(int accountId, double amount) {
        Account account = em.find(Account.class, accountId);
        account.setBalance(account.getBalance() - amount);
    }

    @Override
    @Transactional
    public void depositBalance(int accountId, double amount) {
        Account account = em.find(Account.class, accountId);
        account.setBalance(account.getBalance() + amount);
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
    @Transactional
    public String findRibOrNullByEmail(String email) {
        List account_id = em.createQuery("Select a.id from Account a where a.client.email= :email").setParameter("email", email).getResultList();

        if (account_id.size() == 1)
            return idBank + account_id.get(0);

        return null;
    }


    @Override
    @Transactional
    public Account findAccountbyRib(String rib) {
        int account_id = Integer.parseInt(rib.substring(5));
        return em.find(Account.class, account_id);
    }
}