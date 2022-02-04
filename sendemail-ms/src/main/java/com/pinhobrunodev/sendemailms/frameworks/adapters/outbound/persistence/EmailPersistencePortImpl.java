package com.pinhobrunodev.sendemailms.frameworks.adapters.outbound.persistence;

import com.pinhobrunodev.sendemailms.application.domains.EmailDomain;
import com.pinhobrunodev.sendemailms.application.ports.EmailPersistencePort;
import com.pinhobrunodev.sendemailms.frameworks.adapters.outbound.entities.EmailEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class EmailPersistencePortImpl implements EmailPersistencePort {

    final ModelMapper modelMapper;
    final EmailMongoRepository emailMongoRepository;

    public EmailPersistencePortImpl(ModelMapper modelMapper, EmailMongoRepository emailMongoRepository) {
        this.modelMapper = modelMapper;
        this.emailMongoRepository = emailMongoRepository;
    }

    @Override
    public void save(EmailDomain emailDomain) {
        log.info("Email domain : {}",emailDomain);
        var emailEntity = modelMapper.map(emailDomain, EmailEntity.class);
        emailMongoRepository.save(emailEntity);
        log.info("Email persisted : {}",emailEntity);
    }
}
