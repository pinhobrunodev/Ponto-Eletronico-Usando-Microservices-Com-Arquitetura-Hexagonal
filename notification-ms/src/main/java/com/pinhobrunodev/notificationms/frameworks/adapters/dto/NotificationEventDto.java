package com.pinhobrunodev.notificationms.frameworks.adapters.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class NotificationEventDto {

    private UUID userId;
    private String fullName;
    private String email;
    private String message;
    private LocalDateTime attendanceAt;

}
