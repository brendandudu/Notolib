package org.miage.dao;

import org.miage.model.Person;

public interface PersonDAO {
    Person findByEmail(String email);
    Person createNew(String fname, String lname, String email, String phone);
}
