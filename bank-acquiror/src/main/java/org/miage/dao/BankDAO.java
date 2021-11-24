package org.miage.dao;
import org.miage.model.Account;
import org.miage.model.Bank;

public interface BankDAO {
    Bank createNewBank(String name);
    Account findAccountByClient(int client_id);
}