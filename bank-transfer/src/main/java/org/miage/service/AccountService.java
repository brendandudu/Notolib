package org.miage.service;
import dto.CallForFunds;
import dto.NotificationDTO;
import dto.Transfer;
import org.apache.camel.Exchange;
import org.miage.exception.AccountNotFoundException;
import org.miage.exception.ClientNotAdultException;
import org.miage.exception.LoanAlreadyExistsException;
import org.miage.model.Account;


public interface AccountService {

    Account findAccountByClientId(int id);

    void withdrawLoanBalance(CallForFunds callForFunds);

    void depositLoanBalance(CallForFunds callForFunds) throws ClientNotAdultException, LoanAlreadyExistsException;

    void withdrawBalance(int accountId, double amount);

    void depositBalance(Transfer transfer);

    void emitRibByEmail(Exchange exchange);

    Account findAccountById(int id);
}
