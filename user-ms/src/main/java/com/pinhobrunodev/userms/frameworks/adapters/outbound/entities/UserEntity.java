package com.pinhobrunodev.userms.frameworks.adapters.outbound.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pinhobrunodev.userms.application.domain.enums.DepartmentType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_USERS")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private DepartmentType departmentType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime creationDate;
    @PrePersist
    public void setCreationDate() {
        creationDate = LocalDateTime.now();
    }

    public UserEntity() {
    }


}
