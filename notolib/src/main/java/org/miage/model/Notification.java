package org.miage.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "notification")
@Entity
@XmlRootElement
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "message")
    private String message;

    @Column(name = "viewed")
    private Boolean viewed;

    public Notification(Person person, String message) {
        this.person = person;
        this.message = message;
        this.viewed = false;
    }

    public Notification(){}

    public Boolean getViewed() {
        return viewed;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}