package org.miage.dao;
import org.miage.model.Account;
import org.miage.model.Bank;

import java.util.Collection;
import java.util.List;

public interface BankDAO {
    Bank createNewBank(String name, int id);
    Account findAccountByClient(int client_id);
    List getAccounts(int bank_id);
}