package org.miage.dao;
import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;
import org.miage.model.Client;


public interface AccountDAO {

    Account createNewAccount(double balance, Client client);

    Account findAccountByClientId(int client_id);

    void withdrawLoanBalance(int accountId, double amount);

    void depositLoanBalance(int accountId, double amount);

    void withdrawBalance(int accountId, double amount);

    void depositBalance(int accountId, double amount);

    String findRibByEmail(String email) throws AccountNotFoundException;

    String findRibOrNullByEmail(String email);

    Account findAccountbyRib(String rib);
}
