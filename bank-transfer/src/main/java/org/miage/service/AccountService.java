package org.miage.service;
import dto.CallForFunds;
import org.apache.camel.Exchange;
import org.miage.model.Account;


public interface AccountService {

    Account findAccountByClientId(int id);

    //Crée un prêt sur le compte de l'acquéreur
    //Utiliser DTO CALLFORFUND
    void createLoanBalance(Account account, double amount);


    //Ajoute le montant du virement sur le compte du notaire
    //UTILISER DTO TRANSFER
    //void addBalance(Account account, double amount);
    float addBalance(Account account, Exchange exchange);

    String findRibByEmail(String email);

    void emitRibByEmail(Exchange exchange);

}
