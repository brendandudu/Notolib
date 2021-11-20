package org.miage;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.miage.model.Notary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@QuarkusTest
public class BookingDAOTest {
    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    public void testImcompatibleDayOfWeekException() {
        Notary e = new Notary();
        em.persist(e);
    }
}
