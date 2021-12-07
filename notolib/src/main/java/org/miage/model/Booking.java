package org.miage.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@NamedQueries(
        {
                @NamedQuery(name = "getAllBookingsByPersonId", query = "Select b from Booking b join b.id.timeSlot t where b.id.acquirer.id = :personId or t.notary.id = :personId"),
                @NamedQuery(name = "getBookingsByPersonAndDate", query = "Select b from Booking b join b.id.timeSlot t where (b.id.acquirer.id = :personId or t.notary.id = :personId) AND b.id.date = :date")
        }
)
@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD)
@Table(name = "booking")
@Entity
public class Booking {
    @EmbeddedId
    private BookingId id;

    public Booking(BookingId id) {
        this.id = id;
    }

    public Booking() {

    }

    public BookingId getId() {
        return id;
    }

    public void setId(BookingId id) {
        this.id = id;
    }

}