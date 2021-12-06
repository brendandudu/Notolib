package org.miage.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.model.WeekDay;
import org.miage.dao.NotNotaryIdException;
import org.miage.model.TimeSlot;
import org.miage.dao.TimeSlotDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@ApplicationScoped
public class TimeSlotServiceImpl implements TimeSlotService{

    @Inject
    TimeSlotDAO timeSlotDAO;

    @ConfigProperty(name = "org.miage.notaryId")
    Integer notaryId;

    @Override
    public void createTimeSlot( int notaryId, String weekDay, LocalTime startTime, LocalTime endTime) {
        notaryId = this.notaryId;
        timeSlotDAO.createTimeSlot(notaryId, WeekDay.valueOf(weekDay), startTime, endTime);
    }

    @Override
    public void deleteTimeSlot(int tsId) {
        timeSlotDAO.deleteTimeSlot(tsId);
    }

    @Override
    public Collection<TimeSlot> getTimeSlotForNotary(int notaryId) throws NotNotaryIdException{
        notaryId = this.notaryId;
        return timeSlotDAO.getTimeSlotForNotary(notaryId);
    }

    @Override
    public Collection<TimeSlot>getAvailableTimeSlotAtDate(LocalDate date){
        return timeSlotDAO.getAvailableTimeSlotAtDate(date);
    }
}