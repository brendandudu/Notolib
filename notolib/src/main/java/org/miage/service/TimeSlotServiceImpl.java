package org.miage.service;

import org.miage.dao.WeekDay;
import org.miage.dao.NotNotaryIdException;
import org.miage.model.Notary;
import org.miage.dao.PersonDAO;
import org.miage.model.TimeSlot;
import org.miage.dao.TimeSlotDAO;
import org.miage.service.TimeSlotService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@ApplicationScoped
public class TimeSlotServiceImpl implements TimeSlotService{

    @Inject
    TimeSlotDAO timeSlotDAO;

    @Override
    public void createTimeSlot( int notaryId, String weekDay, LocalTime startTime, LocalTime endTime) {
        timeSlotDAO.createTimeSlot(notaryId, WeekDay.valueOf(weekDay), startTime, endTime);
    }

    @Override
    public void deleteTimeSlot(int tsId) {
        timeSlotDAO.deleteTimeSlot(tsId);
    }

    @Override
    public Collection<TimeSlot> getTimeSlotForNotary(int notaryId) throws NotNotaryIdException{
        return timeSlotDAO.getTimeSlotForNotary(notaryId);
    }

    @Override
    public Collection<TimeSlot>getAvailableTimeSlotAtDate(LocalDate date){
        return timeSlotDAO.getAvailableTimeSlotAtDate(date);
    }
}