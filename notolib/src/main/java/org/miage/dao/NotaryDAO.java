package org.miage.dao;


import org.miage.model.Acquirer;
import org.miage.model.Notary;

import java.time.LocalDate;
import java.util.Collection;

public interface NotaryDAO {
    Notary findNotaryByEmail(String email);
    Notary createNewNotary(String fname, String lname, String email, String phone);
}
