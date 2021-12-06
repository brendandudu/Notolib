package org.miage.service;

import org.miage.camel.gateways.BookingGateway;
import org.miage.dao.*;
import org.miage.model.Acquirer;
import org.miage.model.Booking;
import org.miage.model.Lodging;
import org.miage.model.TimeSlot;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collection;

@ApplicationScoped
public class BookingServiceImpl implements BookingService{

    @Inject
    BookingDAO bookingDAO;

    @Inject
    LodgingDAO lodgingDAO;

    @Inject
    BookingGateway bookingGateway;


    @Override
    public void bookOnDate(int timeSlotId, int acquirerId, LocalDate date, int lodgingId) throws IncompatibleDayOfWeekException, NotAcquirerIdException {
        Booking b = bookingDAO.bookTimeSlotOnDate(timeSlotId, acquirerId, date);
        Lodging l = lodgingDAO.getLodgingById(lodgingId);
        bookingGateway.sendBooking(
                b.getId().getAcquirer().getEmail(),
                b.getId().getTimeSlot().getNotary().getEmail(),
                l.getPrice().floatValue()); //TODO changer le montant */
    }

    @Override
    public void cancelBooking(int timeSlotId, int acquirerId, LocalDate date) {
        bookingDAO.cancelBooking(timeSlotId, acquirerId, date);
    }

    @Override
    public Collection<Booking> getAllBookings(int personId) {
        return bookingDAO.getAllBookings(personId);
    }
}
