package com.pinhobrunodev.notificationms.frameworks.adapters.config;

import com.pinhobrunodev.notificationms.NotificationMsApplication;
import com.pinhobrunodev.notificationms.application.ports.NotificationPersistencePort;
import com.pinhobrunodev.notificationms.application.ports.NotificationProducerPort;
import com.pinhobrunodev.notificationms.application.services.NotificationServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = NotificationMsApplication.class)
public class BeanConfiguration {

    @Bean
    public NotificationServicePortImpl notificationServicePortImpl(NotificationProducerPort notificationProducerPort, NotificationPersistencePort notificationPersistencePort){
        return new NotificationServicePortImpl(notificationProducerPort,notificationPersistencePort);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
