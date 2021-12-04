package org.miage.resources;

import org.miage.dao.NotNotaryIdException;
import org.miage.model.TimeSlot;
import org.miage.service.TimeSlotService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@Path("/timeslot")
public class TimeSlotResource {

    @Inject
    TimeSlotService timeSlotService;

    @Path("/timeSlot/{tsId}")
    @Transactional
    @DELETE
    public void deleteTimeSlot(@PathParam("tsId") int tsId) {
        timeSlotService.deleteTimeSlot(tsId);
    }

    @Path("/{notaryId}/weekDay/{weekDay}/{startTime}/{endTime}")
    @Transactional
    @POST
    public void createTimeSlot(@PathParam("notaryId") int notaryId, @PathParam("weekDay") String weekDay, @PathParam("startTime") String startTime, @PathParam("endTime") String endTime) {
        LocalTime start= LocalTime.parse(startTime);
        LocalTime end= LocalTime.parse(endTime);
            timeSlotService.createTimeSlot(notaryId, weekDay, start, end);
    }

    @Path("/{notaryId}/timeslots")
    @Produces(MediaType.APPLICATION_XML)
    @GET
    public Collection<TimeSlot> getTimeSlotForNotary(@PathParam("notaryId") int notaryId) {
        try {
            return timeSlotService.getTimeSlotForNotary(notaryId);
        } catch (NotNotaryIdException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Path("/find")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @GET
    public Collection<TimeSlot> getAvailableTimeSlotAtDate(@QueryParam("date") String date){
        LocalDate localDate = LocalDate.parse(date);
        return timeSlotService.getAvailableTimeSlotAtDate(localDate);
    }


}