package org.miage.dao;

import org.miage.model.Account;
import org.miage.model.Acquiror;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Account createNewAccount(int id, float balance, Acquiror acquiror, String rib) {
        Account c = new Account(id, balance, acquiror, rib);
        em.persist(c);
        return c;
    }

    @Override
    @Transactional
    public Account findAccountByEmail(String email) {
        Account a = (Account) em.createQuery("Select a from Account a where a.acquirorEmail=:email").setParameter("email", email).getSingleResult();
        return a;
    }
}
