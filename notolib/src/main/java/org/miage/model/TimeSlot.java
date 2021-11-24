package org.miage.model;

import org.miage.dao.WeekDay;
import org.miage.model.Person;
import org.miage.resources.LocalTimeAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalTime;

@NamedQueries({
        @NamedQuery(name = "getAllTimeSlotByNotaryId", query = "Select t from TimeSlot t where t.notary.id = :notaryId"),
        @NamedQuery(name = "getAvailableTimeSlotAtDate", query = "Select b from Booking b LEFT JOIN b.id.timeSlot t WHERE b.id.timeSlot IS NULL AND b.id.date = :date"),

}
)
@Table(name = "time_slot", indexes = {
        @Index(name = "person_id", columnList = "person_id")
})
@Entity
@XmlType(propOrder = {"id", "dayOfWeek", "startTime", "endTime", "notary"})
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_slot_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Notary notary;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private WeekDay dayOfWeek;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    public TimeSlot(Notary notary, WeekDay dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.notary = notary;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeSlot(){};

    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public WeekDay getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(WeekDay dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Notary getNotary() {
        return notary;
    }

    public void setNotary(Notary notary) {
        this.notary = notary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}