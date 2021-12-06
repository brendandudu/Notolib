package org.miage.resources;

import org.miage.dao.IncompatibleDayOfWeekException;
import org.miage.dao.NotAcquirerIdException;
import org.miage.model.Booking;
import org.miage.service.BookingService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Collection;

@Path("/booking")
public class BookingResource {

    @Inject
    BookingService bookingService;


    @Path("/acquirer/{acquirerId}/timeslot/{timeSlotId}/{date}/lodging/{lodgingId}")
    @Transactional
    @POST
    public void makeBooking(@PathParam("acquirerId") int acquirerId, @PathParam("timeSlotId") int timeSlotId, @PathParam("date") String date, @PathParam("lodgingId") int lodgingId ){
        LocalDate localDate =  LocalDate.parse(date);
        try {
            bookingService.bookOnDate(timeSlotId, acquirerId, localDate, lodgingId);
        } catch (IncompatibleDayOfWeekException | NotAcquirerIdException e) {
            e.printStackTrace();
        }

        //TODO return response status
    }

    @Path("/acquirer/{acquirerId}/timeslot/{timeSlotId}/{date}")
    @Transactional
    @DELETE
    public void cancelBooking(@PathParam("acquirerId") int acquirerId, @PathParam("timeSlotId") int timeSlotId, @PathParam("date") String date ){
        LocalDate localDate =  LocalDate.parse(date);
        bookingService.cancelBooking(timeSlotId, acquirerId, localDate);
    }

    @Path("/user/{personId}/bookings")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @GET
    public Collection<Booking> getBookings(@PathParam("personId") int personId){
        return bookingService.getAllBookings(personId);
    }

}
