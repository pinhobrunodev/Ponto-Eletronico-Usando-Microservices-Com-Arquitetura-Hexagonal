package com.pinhobrunodev.userms.frameworks.adapters.dto;

import com.pinhobrunodev.userms.application.domain.enums.DepartmentType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserEvent {

    private UUID userId;
    private String fullName;
    private String email;
    private String departmentType;
}
