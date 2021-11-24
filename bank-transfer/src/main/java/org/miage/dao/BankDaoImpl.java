package org.miage.dao;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;
import org.miage.model.Bank;

import java.util.List;

@ApplicationScoped
public class BankDaoImpl implements BankDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
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

    @Override
    @Transactional
    public Bank createNewBank(String name, int id) {
        Bank b = new Bank(id,name);
        em.persist(b);
        return b;
    }

    @Override
    public List getAccounts(int bank_id){
        return em.createQuery("SELECT a FROM Account a where a.bank=:bank").setParameter("bank", bank_id).getResultList();
    }
}