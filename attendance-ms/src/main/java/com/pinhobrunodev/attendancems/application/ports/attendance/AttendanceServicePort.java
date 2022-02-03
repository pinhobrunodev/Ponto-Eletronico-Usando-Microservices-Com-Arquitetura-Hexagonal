package com.pinhobrunodev.attendancems.application.ports.attendance;

import com.pinhobrunodev.attendancems.application.domains.AttendanceDomain;

import java.util.UUID;

public interface AttendanceServicePort {

    AttendanceDomain saveAttendance(UUID userId);
    void producerAttendanceEventAndSend(AttendanceDomain attendanceDomain);
}
