package com.pinhobrunodev.attendancems.frameworks.adapters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class AttendanceEventDto {


    private UUID userId;
    private String fullName;
    private String email;
    private String departmentType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime attendanceAt;

}
