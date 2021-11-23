package org.miage.resources;

import org.miage.dao.IncompatibleDayOfWeekException;
import org.miage.model.Booking;
import org.miage.service.BookingService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Collection;

@Path("/acquirer")
public class AcquirerResource {

    //TODO voir si mettre dans une class mère Person

    @Inject
    BookingService bookingService;

    @Path("/{acquirerId}/timeslot/{timeSlotId}/{date}")
    @Transactional
    @DELETE
    public void cancelBooking(@PathParam("acquirerId") int acquirerId, @PathParam("timeSlotId") int timeSlotId, @PathParam("date") String date ){
        LocalDate localDate =  LocalDate.parse(date);
        bookingService.cancelBooking(timeSlotId, acquirerId, localDate);
    }

    @Path("/{acquirerId}/timeslot/{timeSlotId}/{date}")
    @Transactional
    @POST
    public void makeBooking(@PathParam("acquirerId") int acquirerId, @PathParam("timeSlotId") int timeSlotId, @PathParam("date") String date ){
        LocalDate localDate =  LocalDate.parse(date);
        try {
            bookingService.bookOnDate(timeSlotId, acquirerId, localDate);
        } catch (IncompatibleDayOfWeekException e) {
            e.printStackTrace();
        }

        //TODO return response status
    }

    @Path("/{acquirerId}/bookings")
    @Produces(MediaType.APPLICATION_XML)
    @GET
    public Collection<Booking> getBookings(@PathParam("acquirerId") int personId){
        return bookingService.getAllBookings(personId);
    }
}
