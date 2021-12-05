package org.miage.dao;

import org.jboss.logging.Logger;
import org.miage.model.Notary;
import org.miage.model.TimeSlot;
import org.miage.model.WeekDay;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@ApplicationScoped
public class TimeSlotDAOImpl implements TimeSlotDAO {
    @PersistenceContext
    EntityManager em;

    private static final Logger LOG = Logger.getLogger(TimeSlotDAOImpl.class);


    @Override
    public Collection<TimeSlot> getTimeSlotForNotary(int notaryId) throws NotNotaryIdException {
        Notary n = em.find(Notary.class, notaryId);
        if(n == null)
            throw new NotNotaryIdException();

        return em.createNamedQuery("getAllTimeSlotByNotaryId").setParameter("notaryId", notaryId).getResultList();
    }

    @Override
    public Collection<TimeSlot> getAvailableTimeSlotAtDate(LocalDate date) {
        WeekDay wd = WeekDay.valueOf(date.getDayOfWeek().name());

        return em.createNamedQuery("getAvailableTimeSlotAtDate").setParameter("date", date).setParameter("dayOfWeek", wd).getResultList();
    }

    @Override
    public void createTimeSlot(int notaryId, WeekDay weekDay, LocalTime startTime, LocalTime endTime) {
        TimeSlot ts = new TimeSlot(notaryId, weekDay, startTime, endTime);
        em.persist(ts);
    }

    @Override
    public void deleteTimeSlot(int tsId) {
        TimeSlot ts = em.find(TimeSlot.class, tsId);
        em.remove(ts);
    }
}
