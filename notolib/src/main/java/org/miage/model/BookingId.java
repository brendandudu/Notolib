package org.miage.model;

import org.hibernate.Hibernate;
import org.miage.resources.LocalDateAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@XmlType(propOrder = {"date", "acquirer", "timeSlot"})
public class BookingId implements Serializable {
    private static final long serialVersionUID = -3314253734620153355L;

    @ManyToOne(cascade = CascadeType.ALL)
    private Acquirer acquirer;

    @ManyToOne(cascade = CascadeType.ALL)
    private TimeSlot timeSlot;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public BookingId(Acquirer acquirer, TimeSlot timeSlot, LocalDate date) {
        this.acquirer = acquirer;
        this.timeSlot = timeSlot;
        this.date = date;
    }

    public BookingId() {

    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

}