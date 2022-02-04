package com.pinhobrunodev.sendemailms.frameworks.adapters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationCommandDto {
    private UUID userId;
    private String fullName;
    private String email;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime attendanceAt;

    public NotificationCommandDto() {
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
