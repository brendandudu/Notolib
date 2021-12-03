package org.miage.service;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.camel.Exchange;
import org.miage.dao.AccountDAO;
import org.miage.model.Account;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

    @Inject
    AccountDAO accountDAO;

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public String findRibByEmail(String email) {
        return accountDAO.findRibByEmail(email);
    }

    @Override
    public void emitRibByEmail(Exchange exchange) {
        String email = exchange.getIn().getBody(String.class);

        String rib = accountDAO.findRibOrNullByEmail(email);
        if(rib != null) {
            exchange.getMessage().setHeader("isInMyBank", true);
            exchange.getMessage().setBody(rib);
            return;
        }

        exchange.getMessage().setHeader("isInMyBank", false);
    }
}