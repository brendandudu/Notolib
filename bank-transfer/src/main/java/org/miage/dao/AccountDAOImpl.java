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
    @Transactional
    public Account findAccountById(int id) {
        String rib;
        Account c = (Account) em.createQuery("Select c from Account c where c.id=:id").setParameter("id", id).getSingleResult();
        return c;
        //rib = Integer.toString(c) + "25";
        //return rib;
    }

    @Override
    @Transactional
    public Account createNewAccount(int id, float balance, Notaire notaire) {
        Account c = new Account(id, balance, notaire);
        em.persist(c);
        return c;
    }
    /*@Override
    public List getAccounts(int bank_id){
        return em.createQuery("SELECT a FROM Account a where a.bank=:bank").setParameter("bank", bank_id).getResultList();
    }*/
}
