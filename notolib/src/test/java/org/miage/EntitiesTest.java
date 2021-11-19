package org.miage;

import org.junit.jupiter.api.Test;
import org.miage.model.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

public class EntitiesTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    public void addNotary() {
        Notary e = new Notary();
        em.persist(e);
    }

    @Test
    @Transactional
    public void addAcquirer() {
        Acquirer e = new Acquirer();
        em.persist(e);
    }

    @Test
    @Transactional
    public void addTimeSlot() {
        Notary e = em.find(Notary.class, 1);
        TimeSlot ts = new TimeSlot();
        ts.setDayOfWeek("mardi");
        ts.setStartTime(LocalTime.of(14,10));
        ts.setEndTime(LocalTime.of(14,20));
        ts.setNotary(e);
        em.persist(ts);
    }

    @Test
    @Transactional
    public void addBooking() {
        Acquirer a = em.find(Acquirer.class, 2);
        TimeSlot ts = em.find(TimeSlot.class, 1);
        BookingId id = new BookingId();
        id.setAcquirer(a);
        id.setTimeSlot(ts);
        id.setDate(LocalDate.now());
        Booking b = new Booking();
        b.setId(id);
        em.persist(b);
    }
}
