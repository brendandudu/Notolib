package org.miage.exception;

import org.miage.model.Client;

public class ClientNotAdultException extends Throwable {

    private String error;

    public ClientNotAdultException(Client client) {
        this.error = "Le client "+client.getFirstName()+" "+client.getLastName()+" n'est pas majeur";
    }

    public String getErrorMessage() {
        return this.error;
    }
}

