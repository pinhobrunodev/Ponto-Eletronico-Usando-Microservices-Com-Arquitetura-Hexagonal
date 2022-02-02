package com.pinhobrunodev.userms.frameworks.adapters.configs;

import com.pinhobrunodev.userms.UserMsApplication;
import com.pinhobrunodev.userms.application.ports.UserPersistencePort;
import com.pinhobrunodev.userms.application.ports.UserProducerPort;
import com.pinhobrunodev.userms.application.services.UserServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = UserMsApplication.class)
@Configuration
public class BeanConfiguration {

    @Bean
    public UserServicePortImpl userServicePortImpl(UserProducerPort userProducerPort, UserPersistencePort userPersistencePort){
        return new UserServicePortImpl(userProducerPort,userPersistencePort);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
