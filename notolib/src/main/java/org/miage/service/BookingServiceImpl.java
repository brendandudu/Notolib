package org.miage.service;

import org.miage.dao.BookingDAO;
import org.miage.dao.IncompatibleDayOfWeekException;
import org.miage.dao.NotAcquirerIdException;
import org.miage.dao.PersonDAO;
import org.miage.model.Acquirer;
import org.miage.model.Booking;
import org.miage.model.TimeSlot;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collection;

@RequestScoped
public class BookingServiceImpl implements BookingService{

    @Inject
    BookingDAO bookingDAO;


    @Override
    public void bookOnDate(int timeSlotId, int acquirerId, LocalDate date) throws IncompatibleDayOfWeekException, NotAcquirerIdException {
        bookingDAO.bookTimeSlotOnDate(timeSlotId, acquirerId, date);
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
