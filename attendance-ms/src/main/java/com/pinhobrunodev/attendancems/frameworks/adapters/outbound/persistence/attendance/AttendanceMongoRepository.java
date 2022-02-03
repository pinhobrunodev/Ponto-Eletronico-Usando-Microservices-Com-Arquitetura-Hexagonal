package com.pinhobrunodev.attendancems.frameworks.adapters.outbound.persistence.attendance;

import com.pinhobrunodev.attendancems.frameworks.adapters.outbound.entities.AttendanceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AttendanceMongoRepository extends CrudRepository<AttendanceEntity, UUID> {
}
