package org.miage.dao;
import org.miage.model.Account;
import org.miage.model.Client;


public interface AccountDAO {
    Account createNewAccount(double balance, Client client);
    Account findAccountByClientId(int client_id);
    Account findRibByEmail(String email);

    String findRibByAccountId(int id);

    void createLoanBalance(Account start, double amount);

    void addBalance(Account account, double amount);
}
