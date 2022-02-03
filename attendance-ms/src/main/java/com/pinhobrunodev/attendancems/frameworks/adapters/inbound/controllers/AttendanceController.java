package com.pinhobrunodev.attendancems.frameworks.adapters.inbound.controllers;

import com.pinhobrunodev.attendancems.application.domains.AttendanceDomain;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendanceServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping(value = "/attendances")
@RestController
public class AttendanceController {

    final AttendanceServicePort attendanceServicePort;

    public AttendanceController(AttendanceServicePort attendanceServicePort) {
        this.attendanceServicePort = attendanceServicePort;
    }

    @PostMapping(value = "/{userId}/attend")
    public ResponseEntity<AttendanceDomain> registerAttendance(@PathVariable UUID userId){
        return ResponseEntity.ok().body(attendanceServicePort.saveAttendance(userId));
    }
}
