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
    @JoinColumn(name = "notaire_id", nullable = false)
    private Notaire notaire;

    public Account(int id, float balance, Notaire notaire) {

    }

    public Account() {

    }

    public Notaire getNotaire() {
        return notaire;
    }

    public void setNotaire(Notaire notaire) {
        this.notaire = notaire;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}