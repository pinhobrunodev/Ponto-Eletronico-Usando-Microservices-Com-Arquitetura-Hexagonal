package com.pinhobrunodev.attendancems.application.ports.attendance;

import com.pinhobrunodev.attendancems.application.domains.AttendanceDomain;

import java.util.UUID;

public interface AttendancePersistPort {

    AttendanceDomain save (UUID userId);
}
