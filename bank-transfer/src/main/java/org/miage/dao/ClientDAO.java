package org.miage.dao;

public interface ClientDAO {
    Client createNewClient(String fname, String lname, String email, String phone, Bank bank);
}
