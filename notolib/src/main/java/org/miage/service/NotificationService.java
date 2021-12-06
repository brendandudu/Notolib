package org.miage.service;

import dto.NotificationDTO;
import org.miage.model.Notification;

import java.util.Collection;

public interface NotificationService {
    void createUserNotificationByDTO(NotificationDTO notificationDTO);
    void createUserNotification(int userId, String message);
    void setAllUserNotificationsViewed(int userId);
    Collection<Notification> getAllUserNotifications(int userId);
    int getUserNewNotificationsCount(int userId);
}
