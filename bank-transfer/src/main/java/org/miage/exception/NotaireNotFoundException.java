package org.miage.exception;

public class NotaireNotFoundException extends Exception {
    public static class NoNotaireAvailableException extends Throwable {
        public NoNotaireAvailableException(int id) {
            super("No available seat for " + id);
        }
    }
}