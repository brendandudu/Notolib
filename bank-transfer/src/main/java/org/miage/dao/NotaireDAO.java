package org.miage.dao;
import org.miage.model.Notaire;

public interface NotaireDAO {
    Notaire createNewNotaire(String fname, String lname, String email, String phone);
}