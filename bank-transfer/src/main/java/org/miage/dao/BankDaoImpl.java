package org.miage.dao;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;
import org.miage.model.Bank;

@ApplicationScoped
public class BankDaoImpl {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //@Override
    @Transactional
    public Account findAccountByClient(int client_id) {
        Account a = em.find(Account.class, client_id);
        if (null == a) {
            try {
                throw new AccountNotFoundException();
            } catch (AccountNotFoundException e) {
                e.printStackTrace();
            }
        }
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