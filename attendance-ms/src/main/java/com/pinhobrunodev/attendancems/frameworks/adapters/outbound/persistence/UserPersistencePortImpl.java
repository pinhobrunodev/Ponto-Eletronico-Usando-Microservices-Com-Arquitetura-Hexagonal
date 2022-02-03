package com.pinhobrunodev.attendancems.frameworks.adapters.outbound.persistence;

import com.pinhobrunodev.attendancems.application.domains.UserDomain;
import com.pinhobrunodev.attendancems.application.ports.UserPersistencePort;
import com.pinhobrunodev.attendancems.frameworks.adapters.outbound.entities.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserPersistencePortImpl implements UserPersistencePort {

    final ModelMapper modelMapper;
    final UserMongoRepository userMongoRepository;

    public UserPersistencePortImpl(ModelMapper modelMapper, UserMongoRepository userMongoRepository) {
        this.modelMapper = modelMapper;
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public void save(UserDomain userDomain) {
        var userEntity = modelMapper.map(userDomain, UserEntity.class);
        userMongoRepository.save(userEntity);
        log.info("User Persisted : {} ",userEntity);
    }
}
