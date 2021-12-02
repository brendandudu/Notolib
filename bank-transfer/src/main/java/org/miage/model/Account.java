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
    @JoinColumn(name = "notary_id", nullable = false)
    private Notaire notary_id;

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

    public Double getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    public Notaire getNotary_id() {
        return notary_id;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNotary_id(Notaire notary_id) {
        this.notary_id = notary_id;
    }
}