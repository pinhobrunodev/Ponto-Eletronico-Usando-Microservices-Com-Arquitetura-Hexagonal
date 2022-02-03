package com.pinhobrunodev.attendancems.application.domains;

import java.time.LocalDateTime;
import java.util.UUID;

public class AttendanceDomain {

    private UUID attendanceId;
    private UUID userId;
    private String fullName;
    private String email;
    private String departmentType;
    private LocalDateTime attendanceAt;

    public AttendanceDomain(UUID attendanceId, UUID userId, String fullName, String email, String departmentType, LocalDateTime attendanceAt) {
        this.attendanceId = attendanceId;
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.departmentType = departmentType;
        this.attendanceAt = attendanceAt;
    }

    public AttendanceDomain() {
    }

    public UUID getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(UUID attendanceId) {
        this.attendanceId = attendanceId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public LocalDateTime getAttendanceAt() {
        return attendanceAt;
    }

    public void setAttendanceAt(LocalDateTime attendanceAt) {
        this.attendanceAt = attendanceAt;
    }
}
