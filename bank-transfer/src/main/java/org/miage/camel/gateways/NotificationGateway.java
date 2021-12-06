package org.miage.camel.gateways;

import dto.NotificationDTO;

public interface NotificationGateway {
    void sendNotification(NotificationDTO notificationDTO);
}
