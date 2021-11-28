package org.miage.service;

import org.miage.dao.AccountDAO;
import org.miage.model.Account;

import javax.inject.Inject;

public class BankAcquirorServiceImpl implements BankAcquirorService {
    @Inject
    AccountDAO accountDAO;


    public Account getAccountByEmailAcquiror(String email) {

        return accountDAO.findAccountByEmail(email);
    }
}
