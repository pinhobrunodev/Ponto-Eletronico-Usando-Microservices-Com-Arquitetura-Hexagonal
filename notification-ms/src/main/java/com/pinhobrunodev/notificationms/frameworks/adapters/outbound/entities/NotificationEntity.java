package com.pinhobrunodev.notificationms.frameworks.adapters.outbound.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@RedisHash("Notification")
public class NotificationEntity implements Serializable {

    @Id
    private UUID notificationId;
    @Indexed
    private UUID userId;
    private String fullName;
    private String email;
    private String departmentType;
    private String message;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime attendanceAt;
}
