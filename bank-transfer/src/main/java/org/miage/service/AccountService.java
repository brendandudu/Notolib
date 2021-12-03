package org.miage.service;
import org.miage.model.Account;


public interface AccountService {
    Account findAccountByClientId(int id);
    String findRibByAccountId(int id);
}
