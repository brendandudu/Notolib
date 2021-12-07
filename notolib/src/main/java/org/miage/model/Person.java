package org.miage.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import java.util.Collection;

@Table(name = "person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type")
@Entity
@XmlType(propOrder = {"id", "firstName", "lastName", "email", "phoneNumber"})
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number", length = 150)
    private String phoneNumber;

    public Person(){};
    public Person(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}