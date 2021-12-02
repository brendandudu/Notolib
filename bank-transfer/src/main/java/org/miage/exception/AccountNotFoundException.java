package org.miage.exception;

public class AccountNotFoundException extends Exception {
    public static class NoAccountAvailableException extends Throwable {
        public NoAccountAvailableException(int id) {
            super("No available account for " + id);
        }
    }
}

/*
public class UnsuficientBalanceForTransactionException extends Throwable {
    public UnsuficientBalanceForTransactionException(double balance) {
        super("not enough balance for transaction " + balance);
    }
}
*/