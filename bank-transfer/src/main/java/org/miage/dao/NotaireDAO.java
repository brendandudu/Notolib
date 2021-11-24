package org.miage.dao;
import org.miage.model.Notaire;
import org.miage.model.Bank;

public interface NotaireDAO {
    Notaire createNewNotaire(String fname, String lname, String email, String phone, Bank bank);
}
