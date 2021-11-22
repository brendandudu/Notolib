package org.miage.service;

import org.miage.dao.IncompatibleDayOfWeekException;
import org.miage.model.Acquirer;
import org.miage.model.Booking;
import org.miage.model.TimeSlot;

import java.time.LocalDate;

public interface BookingService {
    void bookOnDate(int timeSlotId, int acquirerId, LocalDate date) throws IncompatibleDayOfWeekException;
    void cancelBooking(int bookingId);
}
