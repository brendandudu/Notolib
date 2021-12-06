package org.miage.service;

import org.miage.dao.NotificationDAO;
import org.miage.model.Notification;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class NotificationServiceImpl implements NotificationService{

    @Inject
    NotificationDAO notificationDAO;

    @Override
    public void createUserNotification(int userId, String message) {
        notificationDAO.createUserNotification(userId, message);
    }

    @Override
    public void setAllUserNotificationsViewed(int userId) {
        notificationDAO.setAllUserNotificationsViewed(userId);
    }

    @Override
    public Collection<Notification> getAllUserNotifications(int userId) {
        return notificationDAO.getAllUserNotifications(userId);
    }

    @Override
    public int getUserNewNotificationsCount(int userId) {
        return notificationDAO.getUserNewNotificationsCount(userId);
    }
}
