package org.miage.exception;

public class AccountNotFoundException extends Exception {
    public static class NoAccountAvailableException extends Throwable {
        public NoAccountAvailableException(int id) {
            super("No available seat for " + id);
        }
    }
}