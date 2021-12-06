package org.miage.dao;

import org.miage.model.Notification;

import java.util.Collection;

public interface NotificationDAO {

    void createUserNotification(int userId, String message);
    void setAllUserNotificationsViewed(int userId);
    Collection<Notification> getAllUserNotifications(int userId);
    int getUserNewNotificationsCount(int userId);
}
