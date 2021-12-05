package org.miage.service;

import dto.CallForFunds;
import dto.Transfer;
import org.apache.camel.Exchange;
import org.jboss.logging.Logger;
import org.miage.dao.AccountDAO;
import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

    @Inject
    AccountDAO accountDAO;

    @Override
    public Account findAccountByClientId(int client_id) {
        return accountDAO.findAccountByClientId(client_id);
    }

    @Override
    public void withdrawLoanBalance(CallForFunds callForFunds) {
        Account account = accountDAO.findAccountbyRib(callForFunds.getRibDebtor());
        accountDAO.withdrawLoanBalance(account.getId(), (double) callForFunds.getAmount());
    }

    @Override
    public void depositLoanBalance(CallForFunds callForFunds) {
        Account account = accountDAO.findAccountbyRib(callForFunds.getRibDebtor());
        accountDAO.depositLoanBalance(account.getId(), (double) callForFunds.getAmount());
    }

    @Override
    public void withdrawBalance(int accountId, double amount) {
        accountDAO.withdrawBalance(accountId, amount);
    }

    @Override
    public void depositBalance(Transfer transfer) {
        Account account = accountDAO.findAccountbyRib(transfer.getRibCreditor());
        accountDAO.depositBalance(account.getId(), transfer.getAmount());
    }

    @Override
    public String findRibByEmail(String email) throws AccountNotFoundException {
        return accountDAO.findRibByEmail(email);
    }

    @Override
    public void emitRibByEmail(Exchange exchange) {
        String email = exchange.getIn().getBody(String.class);

        String rib = accountDAO.findRibOrNullByEmail(email);
        if (rib != null) {
            exchange.getMessage().setHeader("isInMyBank", true);
            exchange.getMessage().setBody(rib);
            return;
        }
        exchange.getMessage().setHeader("isInMyBank", false);
    }

}
