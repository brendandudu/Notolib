package org.miage.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.dao.NotificationDAO;
import org.miage.model.Notification;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class NotificationServiceImpl implements NotificationService{

    @Inject
    NotificationDAO notificationDAO;

    @ConfigProperty(name = "org.miage.activeUserId")
    Integer userId;

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
