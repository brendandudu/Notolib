package org.miage.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(name = "booking")
@Entity
public class Booking {
    @EmbeddedId
    private BookingId id;

    public BookingId getId() {
        return id;
    }

    public void setId(BookingId id) {
        this.id = id;
    }
}