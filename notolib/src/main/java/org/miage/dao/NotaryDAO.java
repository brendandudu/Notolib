package org.miage.dao;


import org.miage.model.Notary;

public interface NotaryDAO {
    Notary findNotaryByEmail(String email);
    Notary createNewNotary(String fname, String lname, String email, String phone);
}
