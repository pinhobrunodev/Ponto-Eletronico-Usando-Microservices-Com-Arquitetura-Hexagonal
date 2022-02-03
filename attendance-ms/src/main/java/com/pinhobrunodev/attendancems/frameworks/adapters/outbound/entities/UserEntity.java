package com.pinhobrunodev.attendancems.frameworks.adapters.outbound.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document(collection = "users")
public class UserEntity implements Serializable {

    @Id
    private String id;
    @Indexed
    private UUID userId;
    private String fullName;
    private String email;
    private String departmentType;
}
