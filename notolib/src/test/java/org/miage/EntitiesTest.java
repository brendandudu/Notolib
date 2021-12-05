package org.miage;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntitiesTest {
/*
    //TODO rajouter les assert !
    private static final Logger log = Logger.getLogger(EntitiesTest.class);

    @PersistenceContext
    EntityManager em;

    @Inject
    BookingDAO bookingDAO;

    @Test
    @Order(1)
    @Transactional
    public void addNotary() {
        Notary e = new Notary();
        em.persist(e);

    }

    @Test
    @Order(2)
    @Transactional
    public void addAcquirer() {
        Acquirer e = new Acquirer();
        em.persist(e);
    }

    @Test
    @Order(3)
    @Transactional
    public void addTimeSlot() {
        Notary e = em.find(Notary.class, 1);
        TimeSlot ts = new TimeSlot();
        ts.setDayOfWeek(WeekDay.FRIDAY);
        ts.setStartTime(LocalTime.of(14,10));
        ts.setEndTime(LocalTime.of(14,20));
        ts.setNotary(e);
        em.persist(ts);
    }

    @Test
    @Order(4)
    @Transactional
    public void addBooking() {
        Acquirer a = em.find(Acquirer.class, 2);
        TimeSlot ts = em.find(TimeSlot.class, 1);
        BookingId id = new BookingId(a,ts,LocalDate.now());
        Booking b = new Booking(id);
        em.persist(b);
    }


    //todo déplacer dans package différents + créer un jeu de données dans fichier sql + ajouter assert

    @Test
    @Order(5)
    @Transactional
    public void imcompatibleDayOfWeekException() {
        assertThrows(IncompatibleDayOfWeekException.class, () ->
                bookingDAO.bookTimeSlotOnDate(1, 2, LocalDate.of(2021,11,20)));
    }

    @Test
    @Order(6)
    @Transactional
    public void getBookings() {
        log.info(bookingDAO.getAllBookings(2).size());
    }

    @Test
    @Order(7)
    @Transactional
    public void getBookingsByDate() {
        log.info(bookingDAO.getBookingsByDate(2, LocalDate.now()).size());
        log.info(LocalDate.of(2021,11,15));
        log.info(bookingDAO.getBookingsByDate(2, LocalDate.of(2021,11,15)).size());
    }*/
}
