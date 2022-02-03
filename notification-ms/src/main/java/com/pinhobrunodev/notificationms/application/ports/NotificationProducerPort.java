package com.pinhobrunodev.notificationms.application.ports;

import com.pinhobrunodev.notificationms.application.domain.NotificationDomain;

public interface NotificationProducerPort {

    void producerNotificationEventAndSend(NotificationDomain notificationDomain);
}
