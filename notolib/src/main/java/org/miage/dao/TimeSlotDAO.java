package org.miage.dao;

import org.miage.model.Notary;
import org.miage.model.TimeSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

public interface TimeSlotDAO {

    Collection<TimeSlot> getTimeSlotForNotary(int notaryId) throws NotNotaryIdException;
    Collection<TimeSlot> getAvailableTimeSlotAtDate(LocalDate date);
    void createTimeSlot(int notaryId, WeekDay weekDay, LocalTime startTime, LocalTime endTime);
    void deleteTimeSlot(int tsId);

}
