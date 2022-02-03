package com.pinhobrunodev.attendancems.frameworks.adapters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class AttendanceEventDto {


    private UUID userId;
    private String fullName;
    private String email;
    private String departmentType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime attendanceAt;

}
