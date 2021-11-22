package org.miage.dao;
import javax.transaction.Transactional;
import org.miage.model.Account;
import org.miage.model.Client;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.enterprise.context.ApplicationScoped;
//import fr.pantheonsorbonne.ufr27.miage.exception.AccountNotFoundException;

@ApplicationScoped
public class AccountDAOImpl {
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

    //@Override
    @Transactional
    public Account createNewCustomer(int id, float balance, Client client) {
        Account c = new Account(id, balance, client);
        em.persist(c);
        return c;
    }
}
