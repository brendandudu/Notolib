package org.miage.service;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.miage.dao.AccountDAO;
import org.miage.model.Account;

@RequestScoped
public class AccountServiceImpl implements AccountService {

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
}