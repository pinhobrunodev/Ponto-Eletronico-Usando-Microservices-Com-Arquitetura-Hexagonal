package com.pinhobrunodev.attendancems.application.ports.attendance;

import com.pinhobrunodev.attendancems.application.domains.AttendanceDomain;

public interface AttendanceProducerPort {

    void producerAttendanceEventAndSend(AttendanceDomain attendanceDomain);
}
