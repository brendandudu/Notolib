package org.miage.dao;

import org.miage.model.Account;
import org.miage.model.Acquiror;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {
    @PersistenceContext(name = "mysql")
    EntityManager em;

    /*@Override
    public Account findClient(Client client) { throws AccountNotFoundException
        try {
            Account c = (Account) em.createQuery("Select c from Account c where c.client=:client").setParameter("client", client).getSingleResult();
            return c;
        }
        catch (NoResultException e) { throw new AcccountNotFoundException();
        }
    }*/


    @Override
    public Account createNewAccount(int id, float balance, Acquiror acquiror) {
        Account c = new Account(id, balance, acquiror);
        em.persist(c);
        return c;
    }
}
