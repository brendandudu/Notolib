package org.miage.dao;
import org.miage.model.Account;
import org.miage.model.Notaire;


public interface AccountDAO {
    Account createNewAccount(int id, float balance, Notaire notaire, String rib);
    Account findAccountById(int id);
    Account findRibByEmail(String email);
}
