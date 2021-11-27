package org.miage.dao;

import org.miage.model.Booking;

import java.time.LocalDate;
import java.util.Collection;

public interface BookingDAO {

    Booking findBookingById(int bookingId);
    void cancelBooking(int timeSlotId, int acquirer, LocalDate date);
    Booking bookTimeSlotOnDate(int timeSlotId, int acquirer, LocalDate date) throws IncompatibleDayOfWeekException, NotAcquirerIdException;
    Collection<Booking> getAllBookings (int personId);
    Collection<Booking> getBookingsByDate(int personId, LocalDate date);
}
