package com.pinhobrunodev.userms.frameworks.adapters.outbound.persistence;

import com.pinhobrunodev.userms.application.domain.UserDomain;
import com.pinhobrunodev.userms.application.ports.UserPersistencePort;
import com.pinhobrunodev.userms.application.ports.UserProducerPort;
import com.pinhobrunodev.userms.frameworks.adapters.outbound.entities.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserPersistencePortImpl implements UserPersistencePort {


    final UserJpaRepository userJpaRepository;
    final ModelMapper modelMapper;
    final UserProducerPort userProducerPort;

    public UserPersistencePortImpl(UserJpaRepository userJpaRepository, ModelMapper modelMapper, UserProducerPort userProducerPort) {
        this.userJpaRepository = userJpaRepository;
        this.modelMapper = modelMapper;
        this.userProducerPort = userProducerPort;
    }

    // userDomain already with the information of the UserDto
    @Override
    public UserDomain save(UserDomain userDomain) {
        var userEntity = modelMapper.map(userDomain, UserEntity.class);
        userJpaRepository.save(userEntity);
        userProducerPort.producerUserEventAndSend(userDomain);
        log.info("User for Register payload : {}",userEntity);
        return modelMapper.map(userEntity, UserDomain.class);
    }
}
