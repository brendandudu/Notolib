package org.miage.dao;
import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;
import org.miage.model.Client;


public interface AccountDAO {

    Account createNewAccount(double balance, Client client);

    Account findAccountByClientId(int client_id);

    void createLoanBalance(Account start, double amount);

    void addBalance(Account account, double amount);

    String findRibByEmail(String email) throws AccountNotFoundException;

    Account findAccountbyRib(String rib);
}
