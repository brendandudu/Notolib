package org.miage.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@DiscriminatorValue("N")
public class Notary extends Person{

    public Notary() {
        super();
    }

    public Notary(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
    }

    @OneToMany(mappedBy = "notary")
    private Collection<TimeSlot> timeSlot;

    @XmlTransient
    public Collection<TimeSlot> getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Collection<TimeSlot> timeSlot) {
        this.timeSlot = timeSlot;
    }
}
