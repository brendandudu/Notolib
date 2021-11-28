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


    @Column(name = "rib", nullable = false, length = 5)
    private String rib;

    @ManyToOne(optional = false)
    @JoinColumn(name = "acquiror_email", nullable = false)
    private Acquiror acquirorEmail;

    public Acquiror getAcquirorEmail() {
        return acquirorEmail;
    }

    public void setAcquirorEmail(Acquiror acquirorEmail) {
        this.acquirorEmail = acquirorEmail;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Account(int id, float balance, Acquiror acquiror, String rib) {
    }
    public Account(){

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