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
    private Client client;

    @Column(name = "loan_balance")
    private Double loanBalance;

    public Account(double balance, Client client) {
        this.balance = balance;
        this.client = client;
    }

    public Account() {

    }

    public double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Double loanBalance) {
        this.loanBalance = loanBalance;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}