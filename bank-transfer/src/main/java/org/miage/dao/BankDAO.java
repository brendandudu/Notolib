package org.miage.dao;

public interface BankDAO {
    Bank createNewBank(String name);
    Account findAccountByClient(int client_id);
}