package org.miage.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.miage.dao.AccountDAO;
import org.miage.model.Account;

@RequestScoped
public class AccountServiceImpl implements AccountService{

    @Inject
    AccountDAO accountService;

    @Override
    public Account findAccountByEmail(String email) {
        return accountService.findAccountByEmail(email);
    }
}