package org.miage.service;

import org.miage.dao.IncompatibleDayOfWeekException;
import org.miage.dao.NotAcquirerIdException;
import org.miage.model.Booking;

import java.time.LocalDate;
import java.util.Collection;

public interface BookingService {
    void bookOnDate(int timeSlotId, int acquirerId, LocalDate date) throws IncompatibleDayOfWeekException, NotAcquirerIdException;
    void cancelBooking(int timeSlotId, int acquirerId, LocalDate date);
    Collection<Booking> getAllBookings (int personId);

}
