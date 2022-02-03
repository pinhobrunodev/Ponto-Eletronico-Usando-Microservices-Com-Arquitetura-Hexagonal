package com.pinhobrunodev.attendancems.frameworks.adapters.configs;

import com.pinhobrunodev.attendancems.AttendanceMsApplication;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendancePersistPort;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendanceProducerPort;
import com.pinhobrunodev.attendancems.application.ports.user.UserPersistencePort;
import com.pinhobrunodev.attendancems.application.services.AttendanceServicePortImpl;
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
    public AttendanceServicePortImpl attendanceServicePortImpl (AttendancePersistPort attendancePersistPort, AttendanceProducerPort attendanceProducerPort){
        return new AttendanceServicePortImpl(attendancePersistPort,attendanceProducerPort);
    }

    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}

}
