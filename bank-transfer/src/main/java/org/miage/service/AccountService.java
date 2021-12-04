package org.miage.service;
import dto.CallForFunds;
import dto.Transfer;
import org.apache.camel.Exchange;
import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;


public interface AccountService {

    Account findAccountByClientId(int id);

    //Crée un prêt sur le compte de l'acquéreur
    //Utiliser DTO CALLFORFUND
    //void createLoan(Account account, double amount);
    void createLoan(CallForFunds callForFunds);

    //Ajoute le montant du virement sur le compte du notaire

    void addBalance(Account account, Transfer transfer);

    String findRibByEmail(String email) throws AccountNotFoundException;

    void emitRibByEmail(Exchange exchange) throws AccountNotFoundException;

}
