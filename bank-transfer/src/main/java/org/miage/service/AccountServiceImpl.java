package org.miage.service;

import org.apache.camel.Exchange;
import org.miage.dao.AccountDAO;
import org.miage.model.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    EntityManager em;

    @Inject
    AccountDAO accountDAO;

    @Override
    public Account findAccountByClientId(int client_id) {
        return accountDAO.findAccountByClientId(client_id);
    }

    @Override
    public String findRibByEmail(String email) {
        return accountDAO.findRibByEmail(email);
    }


    @Override
    public void createLoanBalance(Account account, double amount) {
        accountDAO.createLoanBalance(account, amount);
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

    @Override
    public void addBalance(Account account, double amount) {
        accountDAO.addBalance(account, amount);
    }


}
