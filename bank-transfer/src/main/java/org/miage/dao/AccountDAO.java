package org.miage.dao;

import org.miage.model.Account;


public interface AccountDAO {
    Account createNewAccount(int id, float balance, Client client);
}