package com.pinhobrunodev.userms.application.service;

import com.pinhobrunodev.userms.application.domain.UserDomain;
import com.pinhobrunodev.userms.application.ports.UserPersistencePort;
import com.pinhobrunodev.userms.application.ports.UserProducerPort;
import com.pinhobrunodev.userms.application.ports.UserServicePort;
import com.pinhobrunodev.userms.application.services.UserServicePortImpl;
import com.pinhobrunodev.userms.frameworks.adapters.dto.UserDto;
import com.pinhobrunodev.userms.tests.Factory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Slf4j
@ExtendWith({SpringExtension.class, MockitoExtension.class})
public class UserServiceTests {
    private UserServicePort userServicePort;
    @Mock
    private UserProducerPort userProducerPort;
    @Mock
    private UserPersistencePort userPersistencePort;
    @Mock
    private ModelMapper modelMapper;

    private UserDomain userDomainReturn;

    private UserDto userDto;

    @BeforeEach
    public void setUp() throws Exception {
        userDomainReturn = new UserDomain();
        userDto = Factory.createRightUserDto();
        userServicePort = new UserServicePortImpl(userProducerPort, userPersistencePort);
        Mockito.when(userPersistencePort.save(ArgumentMatchers.any())).thenReturn(userDomainReturn);
    }

    @Test
    public void shouldPersistWhenValidBody() {
        var userDomain = userServicePort.saveUser(modelMapper.map(userDto, UserDomain.class));
        log.info("userDomain after : {}", userDomain);
        Assertions.assertNotNull(userDomain);
    }


}
