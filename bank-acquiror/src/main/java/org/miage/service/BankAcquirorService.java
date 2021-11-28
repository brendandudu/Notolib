package org.miage.service;

import org.miage.dao.AccountDAOImpl;
import org.miage.model.Account;
import org.miage.dao.AccountDAO;
import javax.ws.rs.GET;

public interface BankAcquirorService {

    public Account getAccountByEmailAcquiror(String email);

}
