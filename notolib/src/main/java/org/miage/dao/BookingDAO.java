package org.miage.dao;

import org.miage.model.Acquirer;
import org.miage.model.Booking;
import org.miage.model.TimeSlot;

import java.time.LocalDate;
import java.util.Collection;

public interface BookingDAO {

    Booking findBookingById(int bookingId);
    void cancelBooking(int bookingId);
    void bookTimeSlotAtDate(TimeSlot ts, Acquirer acquirer, LocalDate date) throws IncompatibleDayOfWeekException;
    Collection<Booking> getAllBookings (int personId);
    Collection<Booking> getBookingsByDate(int personId, LocalDate date);
}
