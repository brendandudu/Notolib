package org.miage.dao;
import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.context.ApplicationScoped;
import org.miage.model.Account;
import org.miage.model.Notaire;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    @PersistenceContext(name = "mysql")
    EntityManager em;


    @Override
    @Transactional
    public Account findAccountById(int id) {
        Account c = (Account) em.createQuery("Select a from Account a where a.notary_id=:id").setParameter("id", id).getSingleResult();
        return c;
    }


    @Override
    @Transactional
    public Account createNewAccount(int id, float balance, Notaire notaire, String rib) {
        Account c = new Account(id, balance, notaire, rib);
        em.persist(c);
        return c;
    }

    @Override
    @Transactional
    public String findRibByEmail(String email) {
        return (String) em.createQuery("Select a.notary_id.email from Account a where a.notary_id.email=:email").setParameter("email", email).getSingleResult();
    }

    @Override
    @Transactional
    public String findRibOrNullByEmail(String email) {
        return (String) em.createQuery("Select a.notary_id.email from Account a where a.notary_id.email=:email").setParameter("email", email)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

}