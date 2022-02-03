package com.pinhobrunodev.attendancems.frameworks.adapters.outbound.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document(collection = "attendances")
public class AttendanceEntity implements Serializable {

    @Id
    private String attendanceId;
    @Indexed
    private UUID userId;
    private String fullName;
    private String email;
    private String departmentType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @CreatedDate
    private LocalDateTime attendanceAt;
}
