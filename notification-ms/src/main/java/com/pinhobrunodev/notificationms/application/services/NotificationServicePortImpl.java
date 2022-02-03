package com.pinhobrunodev.notificationms.application.services;

import com.pinhobrunodev.notificationms.application.domain.NotificationDomain;
import com.pinhobrunodev.notificationms.application.ports.NotificationPersistencePort;
import com.pinhobrunodev.notificationms.application.ports.NotificationProducerPort;
import com.pinhobrunodev.notificationms.application.ports.NotificationServicePort;

public class NotificationServicePortImpl implements NotificationServicePort {


    final NotificationProducerPort notificationProducerPort;
    final NotificationPersistencePort notificationPersistencePort;

    public NotificationServicePortImpl(NotificationProducerPort notificationProducerPort, NotificationPersistencePort notificationPersistencePort) {
        this.notificationProducerPort = notificationProducerPort;
        this.notificationPersistencePort = notificationPersistencePort;
    }


    @Override
    public void producerNotificationEventAndSend(NotificationDomain notificationDomain) {
        notificationProducerPort.producerNotificationEventAndSend(notificationDomain);
    }

    @Override
    public void saveNotification(NotificationDomain notificationDomain) {
    notificationPersistencePort.save(notificationDomain);
    }
}
