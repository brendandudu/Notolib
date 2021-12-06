package org.miage.exception;

import dto.NotificationDTO;
import org.miage.model.Client;

public class ClientNotAdultException extends Throwable {

    private String error;
    private NotificationDTO notificationDTO;

    public ClientNotAdultException(Client client) {
        this.error = "Le client " + client.getFirstName() + " " + client.getLastName() + " n'est pas majeur";
        this.notificationDTO = new NotificationDTO(client.getEmail(), error);
    }

    public NotificationDTO getNotification() {

        return this.notificationDTO;
    }

    public String getErrorMessage() {
        return this.error;
    }
}

