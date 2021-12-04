package org.miage.service;
import org.miage.model.Account;


public interface AccountService {
    Account findAccountByClientId(int id);
    Account findRibByEmail(String email);
    String findRibByAccountId(int id);

    //Crée un prêt sur le compte de l'acquéreur
    void createLoanBalance(Account account, double amount);

    //Ajoute le montant du virement sur le compte du notaire
    void addBalance(Account account, double amount);
}
