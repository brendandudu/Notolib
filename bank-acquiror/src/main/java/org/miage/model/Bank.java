package org.miage.model;

import javax.persistence.Entity;

@javax.persistence.Table(name = "bank")
@Entity
public class Bank {
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Column(name = "id", nullable = false)
    private Integer id;

    @javax.persistence.Column(name = "name", nullable = false, length = 100)
    private String name;

    public Bank(int id, String name) {
    }

    public Bank(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}