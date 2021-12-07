package org.miage.exception;

import dto.NotificationDTO;
import org.miage.model.Client;

public class LoanAlreadyExistsException extends Throwable {


    private String error;
    private NotificationDTO notificationDTO;

    public LoanAlreadyExistsException(Client client) {
        this.error = "Le client " + client.getFirstName() + " " + client.getLastName() + " a deja un pret en cours de remboursement";
        this.notificationDTO = new NotificationDTO(client.getEmail(), error);
    }

    public NotificationDTO getNotification() {

        return this.notificationDTO;
    }

    public String getErrorMessage() {
        return this.error;
    }
}

