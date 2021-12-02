package org.miage.model;

import javax.persistence.*;

@Table(name = "account")
@Entity
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

    @Column(name = "rib", nullable = false, length = 5)
    private String rib;

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Account(int id, float balance, Client notaire, String rib) {

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