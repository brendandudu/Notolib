package org.miage.dao;

import org.miage.model.Account;
import org.miage.model.Client;


public interface AccountDAO {
    Account createNewAccount(int id, float balance, Client client);
    //Account findClient(Client client);
}
