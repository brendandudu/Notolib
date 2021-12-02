package org.miage.service;
import org.miage.model.Account;


public interface AccountService {
    Account findAccountById(int id);
    Account findRibByEmail(String email);
}