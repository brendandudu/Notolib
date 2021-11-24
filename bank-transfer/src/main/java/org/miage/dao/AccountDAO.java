package org.miage.dao;


public interface AccountDAO {
    Account createNewAccount(int id, float balance, Client client);
}