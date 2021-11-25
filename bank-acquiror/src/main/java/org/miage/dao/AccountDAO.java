package org.miage.dao;
import org.miage.model.Account;
import org.miage.model.Acquiror;


public interface AccountDAO {
    Account createNewAccount(int id, float balance, Acquiror acquiror);

    Account findAccountByRib(int rib);
}