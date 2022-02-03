package com.pinhobrunodev.attendancems.frameworks.adapters.outbound.persistence.attendance;

import com.pinhobrunodev.attendancems.application.domains.AttendanceDomain;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendancePersistPort;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendanceProducerPort;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendanceServicePort;
import com.pinhobrunodev.attendancems.application.ports.user.UserServicePort;
import com.pinhobrunodev.attendancems.frameworks.adapters.outbound.entities.AttendanceEntity;
import com.pinhobrunodev.attendancems.frameworks.adapters.outbound.persistence.user.UserMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.UUID;

@Slf4j
@Component
public class AttendancePersistencePortImpl implements AttendancePersistPort {

    final ModelMapper modelMapper;
    final AttendanceMongoRepository attendanceMongoRepository;
    final AttendanceProducerPort attendanceProducerPort;
    final UserServicePort userServicePort;

    public AttendancePersistencePortImpl(ModelMapper modelMapper, AttendanceMongoRepository attendanceMongoRepository, AttendanceProducerPort attendanceProducerPort, UserServicePort userServicePort) {
        this.modelMapper = modelMapper;
        this.attendanceMongoRepository = attendanceMongoRepository;
        this.attendanceProducerPort = attendanceProducerPort;
        this.userServicePort = userServicePort;
    }

    @Override
    public AttendanceDomain save(UUID userId) {
        log.info("userId: {}", userId);
        var userDomain = userServicePort.findByUUID(userId);
        var attendanceEntity = modelMapper.map(userDomain, AttendanceEntity.class);
        attendanceMongoRepository.save(attendanceEntity);
        log.info("Attendance Persisted : {}", attendanceEntity);
        attendanceProducerPort.producerAttendanceEventAndSend(modelMapper.map(attendanceEntity, AttendanceDomain.class));
        return modelMapper.map(attendanceEntity, AttendanceDomain.class);
    }
}
