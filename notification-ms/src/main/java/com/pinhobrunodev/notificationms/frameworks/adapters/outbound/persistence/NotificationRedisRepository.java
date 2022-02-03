package com.pinhobrunodev.notificationms.frameworks.adapters.outbound.persistence;

import com.pinhobrunodev.notificationms.frameworks.adapters.outbound.entities.NotificationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface NotificationRedisRepository extends CrudRepository<NotificationEntity, UUID> {
}
