package org.miage.exception;

import org.miage.model.Client;

public class LoanCreationNotAllowedException extends Exception {
    public static class ClientIsNotAdultException extends Throwable {
        public ClientIsNotAdultException(Client client) {
            super("Le client " + client.getLastName() + " a " + client.getAge() + " ans et n'est donc pas majeur.");
        }
    }

    public static class LoanAlreadyExistsException extends Throwable {
        public LoanAlreadyExistsException(Client client) {
            super("Le client " + client.getLastName() + "a déjà un prêt en cours.");
        }
    }
}