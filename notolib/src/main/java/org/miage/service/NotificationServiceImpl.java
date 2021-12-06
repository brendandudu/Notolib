package org.miage.service;

import dto.NotificationDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.dao.PersonQualifier;
import org.miage.dao.NotificationDAO;
import org.miage.dao.PersonDAO;
import org.miage.model.Notification;
import org.miage.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class NotificationServiceImpl implements NotificationService{

    @PersonQualifier
    @Inject
    PersonDAO personDAO;

    @Inject
    NotificationDAO notificationDAO;

    @ConfigProperty(name = "org.miage.activeUserId")
    Integer userId;

    @Override
    public void createUserNotificationByDTO(NotificationDTO notificationDTO) {
        Person p = personDAO.findByEmail(notificationDTO.getUserEmail());
        System.out.println("ICIIIIIIIIIIIIIII"+p);
        notificationDAO.createUserNotification(p.getId(), notificationDTO.getMessage());
    }

    @Override
    public void createUserNotification(int userId, String message) {
        userId = this.userId;
        notificationDAO.createUserNotification(userId, message);
    }

    @Override
    public void setAllUserNotificationsViewed(int userId) {
        userId = this.userId;
        notificationDAO.setAllUserNotificationsViewed(userId);
    }

    @Override
    public Collection<Notification> getAllUserNotifications(int userId) {
        userId = this.userId;
        return notificationDAO.getAllUserNotifications(userId);
    }

    @Override
    public int getUserNewNotificationsCount(int userId) {
        userId = this.userId;
        return notificationDAO.getUserNewNotificationsCount(userId);
    }
}
