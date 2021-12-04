package org.miage.service;
import org.miage.model.Account;


public interface AccountService {
    Account findAccountByClientId(int id);
    Account findRibByEmail(String email);
    String findRibByAccountId(int id);
}
