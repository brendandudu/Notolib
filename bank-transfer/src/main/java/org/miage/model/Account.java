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
    @JoinColumn(name = "notaire_email", nullable = false)
    private Notaire notaire_email;

    @Column(name = "rib", nullable = false, length = 5)
    private String rib;

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Account(int id, float balance, Notaire notaire, String rib) {

    }

    public Account() {

    }

    public Notaire getNotaire() {
        return notaire_email;
    }

    public void setNotaire(Notaire notaire) {
        this.notaire_email = notaire;
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