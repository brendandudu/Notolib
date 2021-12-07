package org.miage.service;

import dto.CallForFunds;
import dto.NotificationDTO;
import dto.Transfer;
import org.apache.camel.Exchange;
import org.miage.camel.gateways.NotificationGateway;
import org.miage.dao.AccountDAO;
import org.miage.exception.AccountNotFoundException;
import org.miage.exception.ClientNotAdultException;
import org.miage.exception.LoanAlreadyExistsException;
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
    NotificationGateway notificationGateway;

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
    public void depositLoanBalance(CallForFunds callForFunds) throws ClientNotAdultException, LoanAlreadyExistsException {

        Account account = accountDAO.findAccountbyRib(callForFunds.getRibDebtor());

        if (account.getClient().getAge() >= 18 ){ //on vérifie si le client est majeur
            if (account.getLoanBalance() <= 0){ //on vérifie si le client n'a pas de prêt à rembourser
                accountDAO.depositLoanBalance(account.getId(), (double) callForFunds.getAmount());
                notificationGateway.sendNotification(new NotificationDTO(account.getClient().getEmail(), "Un prêt d'un montant de " + callForFunds.getAmount() + "€ vous a été accordé par votre banque"));
            }else{

                throw new LoanAlreadyExistsException(account.getClient());
            }
        }else{
            throw new ClientNotAdultException(account.getClient());

        }

    }

    @Override
    public void withdrawBalance(int accountId, double amount) {
        accountDAO.withdrawBalance(accountId, amount);
    }

    @Override
    public void depositBalance(Transfer transfer) {
        Account account = accountDAO.findAccountbyRib(transfer.getRibCreditor());
        accountDAO.depositBalance(account.getId(), transfer.getAmount());
        notificationGateway.sendNotification(new NotificationDTO(account.getClient().getEmail(), "Un virement de " + transfer.getAmount() + "€ vient d'être déposé sur votre compte"));
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
    public Account findAccountById(int id) {
        return em.find(Account.class, id);
    }

}
