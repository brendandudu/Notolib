package org.miage.exception;

import org.miage.model.Client;

public class LoanAlreadyExistsException extends Throwable {

    private String error;

    public LoanAlreadyExistsException(Client client) {
        this.error = "Le client " + client.getFirstName() + " " + client.getLastName() + " a deja un pret en cours de remboursement";
    }

    public String getErrorMessage() {
        return this.error;
    }
}

