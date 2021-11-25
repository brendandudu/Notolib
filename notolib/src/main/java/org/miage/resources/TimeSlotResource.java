package org.miage.resources;

import org.miage.dao.NotNotaryIdException;
import org.miage.model.TimeSlot;
import org.miage.service.TimeSlotService;
import org.miage.dao.WeekDay;

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
    public void createTimeSlot(@PathParam("notaryId") int notaryId, @PathParam("weekDay") String weekDay, @PathParam("startTime") LocalTime startTime, @PathParam("endTime") LocalTime endTime) {
            timeSlotService.createTimeSlot(notaryId, weekDay, startTime, endTime);
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

    @Path("/date/{date}")
    @Produces(MediaType.APPLICATION_XML)
    @GET
    public Collection<TimeSlot> getAvailableTimeSlotAtDate(@PathParam("date") LocalDate date){
        return timeSlotService.getAvailableTimeSlotAtDate(date);
    }


}