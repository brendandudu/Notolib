package org.miage.dao;

import org.miage.model.Acquirer;

import java.time.LocalDate;
import java.util.Collection;

public interface AcquirerDAO {
    Collection<Acquirer> findAcquirerByAvailablity(LocalDate date);
    Acquirer createNewAcquirer(String fname, String lname, String email, String phone);
}
