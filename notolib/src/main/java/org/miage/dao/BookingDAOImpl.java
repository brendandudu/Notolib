package org.miage.dao;

import org.miage.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Collection;

@ApplicationScoped
public class BookingDAOImpl implements BookingDAO {
    @PersistenceContext
    EntityManager em;

    @Override
    public Booking findBookingById(int bookingId) {
        return em.find(Booking.class, bookingId);
    }

    @Override
    public void cancelBooking(int timeSlotId, int acquirerId, LocalDate date) {
        Booking b = (Booking) (em.createQuery("Select b from Booking b where b.id.timeSlot.id = :timeSlotId and b.id.acquirer.id = :acquirerId and b.id.date = :date")
                .setParameter("timeSlotId", timeSlotId)
                .setParameter("acquirerId", acquirerId)
                .setParameter("date", date)
                .getSingleResult());
        em.remove(b);
    }

    @Override
    public void bookTimeSlotOnDate(int timeSlotId, int acquirerId, LocalDate date) throws IncompatibleDayOfWeekException, NotAcquirerIdException {
        TimeSlot ts = em.find(TimeSlot.class, timeSlotId);
        Acquirer acquirer = em.find(Acquirer.class, acquirerId);

        if(acquirer == null)
            throw new NotAcquirerIdException();
        if(! ts.getDayOfWeek().toString().equals(date.getDayOfWeek().name()))
            throw new IncompatibleDayOfWeekException();

        Booking b = new Booking(new BookingId(acquirer, ts, date));
        em.persist(b);
    }

    @Override
    public Collection<Booking> getAllBookings(int personId) {
        return em.createNamedQuery("getAllBookingsByPersonId").setParameter("personId", personId).getResultList();
    }

    @Override
    public Collection<Booking> getBookingsByDate(int personId, LocalDate date) {
        return em.createNamedQuery("getBookingsByPersonAndDate").setParameter("personId", personId).setParameter("date", date).getResultList();
    }
}
