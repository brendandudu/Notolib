package org.miage.service;
import com.google.common.hash.Hashing;
//import fr.pantheonsorbonne.ufr27.miage.dto.ETicket;
//import fr.pantheonsorbonne.ufr27.miage.dto.TicketType;
//import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
//import fr.pantheonsorbonne.ufr27.miage.exception.ExpiredTransitionalTicketException;
import org.miage.dao.ClientDAO;
//import org.miage.dao.NoSuchTicketException;
import org.miage.dao.AccountDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {


    @Inject
    ClientDAO clientDAO;

    @Inject
    AccountDAO AccountDAO;


    public String getKeyForBalance(Account account) {
        return Hashing.sha256().hashString(account.getBalance() + "" + account.getId() + "" + account.getBank().getId() + "MySuperSecret75013!", StandardCharsets.UTF_8).toString();
    }

    @Override
    public boolean validateTicket(Account a) {
        return this.getKeyForBalance(a).equals(a.getBalance());
    }
}