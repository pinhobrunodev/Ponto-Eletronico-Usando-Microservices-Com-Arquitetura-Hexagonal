package com.pinhobrunodev.notificationms.frameworks.adapters.outbound.persistence;

import com.pinhobrunodev.notificationms.application.domain.NotificationDomain;
import com.pinhobrunodev.notificationms.application.ports.NotificationPersistencePort;
import com.pinhobrunodev.notificationms.application.ports.NotificationProducerPort;
import com.pinhobrunodev.notificationms.frameworks.adapters.outbound.entities.NotificationEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationPersistencePortImpl implements NotificationPersistencePort {


    final ModelMapper modelMapper;
    final NotificationRedisRepository notificationRedisRepository;
    final NotificationProducerPort notificationProducerPort;

    public NotificationPersistencePortImpl(ModelMapper modelMapper, NotificationRedisRepository notificationRedisRepository, NotificationProducerPort notificationProducerPort) {
        this.modelMapper = modelMapper;
        this.notificationRedisRepository = notificationRedisRepository;
        this.notificationProducerPort = notificationProducerPort;
    }

    @Override
    public void save(NotificationDomain notificationDomain) {
        var notificationEntity = modelMapper.map(notificationDomain, NotificationEntity.class);
        notificationEntity.setMessage("Olá " + notificationEntity.getFullName() + ", você bateu o ponto no seguinte dia/horário: " + notificationEntity.getAttendanceAt());
        notificationRedisRepository.save(notificationEntity);
        log.info("Notification Persisted : {}",notificationEntity);
        notificationProducerPort.producerNotificationEventAndSend(modelMapper.map(notificationEntity,NotificationDomain.class));
    }
}
