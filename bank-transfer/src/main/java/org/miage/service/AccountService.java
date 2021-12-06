package org.miage.service;
import dto.CallForFunds;
import dto.Transfer;
import org.apache.camel.Exchange;
import org.miage.exception.AccountNotFoundException;
import org.miage.exception.LoanCreationNotAllowedException;
import org.miage.model.Account;


public interface AccountService {

    Account findAccountByClientId(int id);

    void withdrawLoanBalance(CallForFunds callForFunds);

    void depositLoanBalance(CallForFunds callForFunds) throws LoanCreationNotAllowedException.ClientIsNotAdultException, LoanCreationNotAllowedException.LoanAlreadyExistsException;

    void withdrawBalance(int accountId, double amount);

    void depositBalance(Transfer transfer);

    String findRibByEmail(String email) throws AccountNotFoundException;

    void emitRibByEmail(Exchange exchange);

}
