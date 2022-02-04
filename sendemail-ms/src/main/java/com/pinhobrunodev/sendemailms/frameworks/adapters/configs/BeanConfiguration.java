package com.pinhobrunodev.sendemailms.frameworks.adapters.configs;

import com.pinhobrunodev.sendemailms.application.ports.EmailPersistencePort;
import com.pinhobrunodev.sendemailms.application.ports.SendEmailServicePort;
import com.pinhobrunodev.sendemailms.application.services.EmailServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = SendEmailServicePort.class)
@Configuration
public class BeanConfiguration {


    @Bean
    public EmailServicePortImpl emailServicePortImpl(EmailPersistencePort emailPersistencePort, SendEmailServicePort sendEmailServicePort) {
        return new EmailServicePortImpl(emailPersistencePort, sendEmailServicePort);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
