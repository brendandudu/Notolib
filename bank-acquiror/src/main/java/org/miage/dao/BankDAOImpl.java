package org.miage.dao;

import org.miage.model.Account;
import org.miage.model.Bank;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class BankDAOImpl {
    @PersistenceContext(name = "mysql")
    EntityManager em;


    //@Override
    @Transactional
    public Bank createNewBank(String name, int id) {
        Bank b = new Bank(id,name);
        em.persist(b);
        return b;
    }
}
