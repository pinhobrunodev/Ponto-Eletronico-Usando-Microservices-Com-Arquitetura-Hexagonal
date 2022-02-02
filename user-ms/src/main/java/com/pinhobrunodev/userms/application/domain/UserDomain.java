package com.pinhobrunodev.userms.application.domain;

import com.pinhobrunodev.userms.application.domain.enums.DepartmentType;

import java.time.LocalDateTime;
import java.util.UUID;


public class UserDomain {

    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private DepartmentType departmentType;
    private LocalDateTime creationDate;


    public UserDomain() {
    }

    public UserDomain(UUID userId, String firstName, String lastName, String email, DepartmentType departmentType, LocalDateTime creationDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentType = departmentType;
        this.creationDate = creationDate;
    }


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
