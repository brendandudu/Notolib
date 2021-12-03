package org.miage.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "account")
@Entity
@XmlRootElement
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client_id;

    public Account(double balance, Client client) {
        this.balance = balance;
        this.client_id = client;

    }

    public Account() {

    }

    public Double getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

}