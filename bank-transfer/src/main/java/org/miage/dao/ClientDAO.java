package org.miage.dao;


import org.miage.model.Bank;
import org.miage.model.Client;

public interface ClientDAO {

    Client createNewClient(String fname, String lname, String email, String phone, Bank bank);
}
