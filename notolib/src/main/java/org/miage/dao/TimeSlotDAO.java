package org.miage.dao;

import org.miage.model.Notary;
import org.miage.model.TimeSlot;

import java.time.LocalTime;
import java.util.Collection;

public interface TimeSlotDAO {

    Collection<TimeSlot> getTimeSlotForNotary(int notaryId) throws NotNotaryIdException;
    void createTimeSlot(Notary notary, WeekDay weekDay, LocalTime startTime, LocalTime endTime);
    void deleteTimeSlot(int tsId);

}
