package org.miage.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@DiscriminatorValue("N")
public class Notary extends Person{

    @OneToMany(mappedBy = "notary")
    private Collection<TimeSlot> timeSlot;

    public Collection<TimeSlot> getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Collection<TimeSlot> timeSlot) {
        this.timeSlot = timeSlot;
    }
}
