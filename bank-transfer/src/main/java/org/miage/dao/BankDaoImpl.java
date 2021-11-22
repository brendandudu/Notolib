package org.miage.dao;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.miage.model.Account;
import org.miage.model.Client;
import org.miage.model.Bank;
import javax.transaction.Transactional;


@ApplicationScoped
public class BankDaoImpl {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //@Override
    @Transactional
    public Account findAccountByClient(int client_id) {
       Account a = em.find(Account.class, client_id);
        /*if (null == a) {
            throw new NoSuchTicketException();
        }*/
        return a;
    }

    //@Override
    @Transactional
    public Bank createNewBank(String name, int id) {
        Bank b = new Bank(id,name);
        em.persist(b);
        return b;
    }
}
