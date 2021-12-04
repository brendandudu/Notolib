package org.miage.service;

import org.miage.dao.NotNotaryIdException;
import org.miage.model.Notary;
import org.miage.dao.WeekDay;
import org.miage.model.TimeSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

public interface TimeSlotService {
    void createTimeSlot(int notaryId, String weekDay, LocalTime startTime, LocalTime endTime);
    void deleteTimeSlot(int tsId);
    Collection<TimeSlot> getTimeSlotForNotary(int notaryId) throws NotNotaryIdException;
    Collection<TimeSlot> getAvailableTimeSlotAtDate(LocalDate date);
}
