package org.miage.service;
import org.miage.model.Account;


public interface AccountService {
    Account findAccountByEmail(String email);
}
