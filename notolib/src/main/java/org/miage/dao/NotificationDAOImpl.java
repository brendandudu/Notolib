package org.miage.dao;

import org.miage.model.Notification;
import org.miage.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class NotificationDAOImpl implements NotificationDAO{

    @Inject
    EntityManager em;

    @Override
    public void createUserNotification(int userId, String message) {
        System.out.println("USEEEER ICI");
        Person user = em.find(Person.class, userId);
        System.out.println(user);
        System.out.println("USEEEER ICI");
        Notification n = new Notification(user, message);
        em.persist(n);
    }

    @Override
    public void setAllUserNotificationsViewed(int userId) {
        em.createQuery("UPDATE Notification n SET n.viewed = TRUE where n.person.id = :userId").setParameter("userId", userId).executeUpdate();
    }

    @Override
    public Collection<Notification> getAllUserNotifications(int userId) {
        return (List<Notification>) em.createQuery("SELECT n FROM Notification n where n.person.id = :userId").setParameter("userId", userId).getResultList();
    }

    @Override
    public int getUserNewNotificationsCount(int userId) {
        return em.createQuery("SELECT n FROM Notification n where n.person.id = :userId and n.viewed = false").setParameter("userId", userId).getResultList().size();
    }
}
