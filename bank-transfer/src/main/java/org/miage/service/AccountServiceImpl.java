package org.miage.service;

import dto.CallForFunds;
import dto.Transfer;
import org.apache.camel.Exchange;
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
    public void createLoan(CallForFunds callForFunds) {
        Account account = accountDAO.findAccountbyRib(callForFunds.getRib());
        account.addLoanBalance(callForFunds.getAmount());
    }

    @Override
    public String findRibByEmail(String email) throws AccountNotFoundException {
        return accountDAO.findRibByEmail(email);
    }

    @Override
    public void emitRibByEmail(Exchange exchange) throws AccountNotFoundException {
        String email = exchange.getIn().getBody(String.class);

        String rib = accountDAO.findRibByEmail(email);
        if (rib != null) {
            exchange.getMessage().setHeader("isInMyBank", true);
            exchange.getMessage().setBody(rib);
            return;
        }
        exchange.getMessage().setHeader("isInMyBank", false);
    }

    @Override
    public void addBalance(Account account, Transfer transfer) {
        account.addBalance(transfer.getAmount());
    }
}
