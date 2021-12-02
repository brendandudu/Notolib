package org.miage.service;
import org.apache.camel.Exchange;
import org.miage.model.Account;


public interface AccountService {
    Account findAccountById(int id);
    String findRibByEmail(String email);
    void emitRibByEmail(Exchange exchange);
}
