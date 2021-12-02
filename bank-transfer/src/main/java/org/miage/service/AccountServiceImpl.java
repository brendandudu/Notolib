package org.miage.service;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.miage.dao.AccountDAO;
import org.miage.model.Account;

@RequestScoped
public class AccountServiceImpl implements AccountService {

    @Inject
    AccountDAO accountService;

    @Override
    public Account findAccountById(int id) {
        return accountService.findAccountById(id);
    }

    @Override
    public Account findRibByEmail(String email) {
        return accountService.findRibByEmail(email);
    }
}