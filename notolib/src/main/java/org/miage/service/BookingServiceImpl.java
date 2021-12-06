package org.miage.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.camel.gateways.BookingGateway;
import org.miage.dao.BookingDAO;
import org.miage.dao.IncompatibleDayOfWeekException;
import org.miage.dao.LodgingDAO;
import org.miage.dao.NotAcquirerIdException;
import org.miage.model.Booking;
import org.miage.model.Lodging;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collection;

@ApplicationScoped
public class BookingServiceImpl implements BookingService {

    @Inject
    BookingDAO bookingDAO;

    @Inject
    LodgingDAO lodgingDAO;

    @Inject
    BookingGateway bookingGateway;

    @Inject
    NotificationService notificationService;

    @ConfigProperty(name = "org.miage.acquirerId")
    Integer acquirerId;

    @ConfigProperty(name = "org.miage.activeUserId")
    Integer userId;

    @Override
    public void bookOnDate(int timeSlotId, int acquirerId, LocalDate date, int lodgingId) throws IncompatibleDayOfWeekException, NotAcquirerIdException {
        //acquirerId = this.acquirerId;
        Booking b = bookingDAO.bookTimeSlotOnDate(timeSlotId, acquirerId, date);
        Lodging l = lodgingDAO.getLodgingById(lodgingId);
        bookingGateway.sendBooking(
                b.getId().getAcquirer().getEmail(),
                b.getId().getTimeSlot().getNotary().getEmail(),
                l.getPrice().floatValue());

        notificationService.createUserNotification(b.getId().getAcquirer().getId(), "Rendez-vous pris le " + b.getId().getDate() + " de " + b.getId().getTimeSlot().getStartTime() + " à " + b.getId().getTimeSlot().getEndTime() + " avec " + b.getId().getTimeSlot().getNotary());

    }

    @Override
    public void cancelBooking(int timeSlotId, int acquirerId, LocalDate date) {
        acquirerId = this.acquirerId;
        bookingDAO.cancelBooking(timeSlotId, acquirerId, date);
    }

    @Override
    public Collection<Booking> getAllBookings(int personId) {
        personId = userId;
        return bookingDAO.getAllBookings(personId);
    }
}
