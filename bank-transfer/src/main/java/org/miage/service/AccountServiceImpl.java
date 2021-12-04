package org.miage.service;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.miage.dao.AccountDAO;
import org.miage.model.Account;

@RequestScoped
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    EntityManager em;

    @Inject
    AccountDAO accountDAO;

    @Override
    public Account findAccountByClientId(int client_id) {
        return accountDAO.findAccountByClientId(client_id);
    }

    @Override
    public Account findRibByEmail(String email) {
        return accountDAO.findRibByEmail(email);
    }
    public String findRibByAccountId(int id) {
        return accountDAO.findRibByAccountId(id);
    }

    @Override
    public void createLoanBalance(Account account, double amount) {
       accountDAO.createLoanBalance(account,amount);
    }

    @Override
    public void addBalance(Account account, double amount) {
        accountDAO.addBalance(account,amount);
    }


}