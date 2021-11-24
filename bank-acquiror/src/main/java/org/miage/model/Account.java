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
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @ManyToOne(optional = false)
    @JoinColumn(name = "acquiror_id", nullable = false)
    private Acquiror acquiror;

    public Account(int id, float balance, Acquiror acquiror) {
    }
    public Account(){

    }

    public Acquiror getAcquiror() {
        return acquiror;
    }

    public void setAcquiror(Acquiror acquiror) {
        this.acquiror = acquiror;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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