package com.pinhobrunodev.attendancems.application.services;

import com.pinhobrunodev.attendancems.application.domains.AttendanceDomain;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendancePersistPort;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendanceProducerPort;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendanceServicePort;

import java.util.UUID;

public class AttendanceServicePortImpl implements AttendanceServicePort {


    final AttendancePersistPort attendancePersistPort;
    final AttendanceProducerPort attendanceProducerPort;

    public AttendanceServicePortImpl(AttendancePersistPort attendancePersistPort, AttendanceProducerPort attendanceProducerPort) {
        this.attendancePersistPort = attendancePersistPort;
        this.attendanceProducerPort = attendanceProducerPort;
    }

    @Override
    public AttendanceDomain saveAttendance(UUID userId) {
        return attendancePersistPort.save(userId);
    }

    @Override
    public void producerAttendanceEventAndSend(AttendanceDomain attendanceDomain) {
        attendanceProducerPort.producerAttendanceEventAndSend(attendanceDomain);
    }
}
