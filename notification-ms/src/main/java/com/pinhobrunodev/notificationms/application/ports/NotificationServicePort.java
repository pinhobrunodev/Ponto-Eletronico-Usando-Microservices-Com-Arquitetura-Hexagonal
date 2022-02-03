package com.pinhobrunodev.notificationms.application.ports;

import com.pinhobrunodev.notificationms.application.domain.NotificationDomain;

public interface NotificationServicePort {

    void producerNotificationEventAndSend(NotificationDomain notificationDomain);
    void saveNotification(NotificationDomain notificationDomain);
}
