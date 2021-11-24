package org.miage.dao;

import org.miage.model.Acquirer;
import org.miage.model.Notary;

import java.time.LocalDate;
import java.util.Collection;

public interface AcquirerDAO {
    Notary findAcquirerByEmail(String email);
    Acquirer createNewAcquirer(String fname, String lname, String email, String phone);
}
