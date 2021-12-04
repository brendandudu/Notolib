package org.miage.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQuery(name = "getAllLodgings", query = "SELECT l FROM Lodging l")
@Table(name = "lodging")
@XmlRootElement
@Entity
public class Lodging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lodging_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person acquirer;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "picture")
    private String picture;

    public Lodging() {
    }

    public Lodging(Person acquirer, String title, String description, Double price, String picture) {
        this.acquirer = acquirer;
        this.title = title;
        this.description = description;
        this.price = price;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Person acquirer) {
        this.acquirer = acquirer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}