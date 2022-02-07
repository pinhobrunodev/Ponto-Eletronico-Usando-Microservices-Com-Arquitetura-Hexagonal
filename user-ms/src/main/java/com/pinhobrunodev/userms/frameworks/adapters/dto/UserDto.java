package com.pinhobrunodev.userms.frameworks.adapters.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.pinhobrunodev.userms.application.domain.enums.DepartmentType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class UserDto {


    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private DepartmentType departmentType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime creationDate;




}
