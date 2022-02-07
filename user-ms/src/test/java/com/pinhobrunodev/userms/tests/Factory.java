package com.pinhobrunodev.userms.tests;

import com.pinhobrunodev.userms.application.domain.UserDomain;
import com.pinhobrunodev.userms.application.domain.enums.DepartmentType;
import com.pinhobrunodev.userms.frameworks.adapters.dto.UserDto;

import java.time.LocalDateTime;

public class Factory {


    public static UserDto createRightUserDto(){
        return new UserDto(null,"brunoTEST","pinhoTEST","brunopinho1010TEST@gmail.com", DepartmentType.TECHNOLOGY_DEPARTMENT, LocalDateTime.now());
    }
}
