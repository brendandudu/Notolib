package org.miage.dao;

import org.miage.model.Acquiror;
import org.miage.model.Bank;

public interface AcquirorDAO {

    Acquiror createNewAcquiror(String fname, String lname, String email, String phone, Bank bank);
}
