package com.pinhobrunodev.attendancems.frameworks.adapters.configs;

import com.pinhobrunodev.attendancems.AttendanceMsApplication;
import com.pinhobrunodev.attendancems.application.ports.UserPersistencePort;
import com.pinhobrunodev.attendancems.application.services.UserServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AttendanceMsApplication.class)
public class BeanConfiguration {

    @Bean
    public UserServicePortImpl userServicePortImpl(UserPersistencePort userPersistencePort){
        return new UserServicePortImpl(userPersistencePort);
    }

    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}

}
