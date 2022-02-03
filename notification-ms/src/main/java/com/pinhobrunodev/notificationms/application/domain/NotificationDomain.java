package com.pinhobrunodev.notificationms.application.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationDomain {

    private UUID notificationId;
    private UUID userId;
    private String fullName;
    private String email;
    private String departmentType;
    private String message;
    private LocalDateTime attendanceAt;

    public NotificationDomain() {
    }

    public NotificationDomain(UUID notificationId, UUID userId, String fullName, String email, String departmentType, String message, LocalDateTime attendanceAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.departmentType = departmentType;
        this.message = message;
        this.attendanceAt = attendanceAt;
    }


    public UUID getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(UUID notificationId) {
        this.notificationId = notificationId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getAttendanceAt() {
        return attendanceAt;
    }

    public void setAttendanceAt(LocalDateTime attendanceAt) {
        this.attendanceAt = attendanceAt;
    }
}
