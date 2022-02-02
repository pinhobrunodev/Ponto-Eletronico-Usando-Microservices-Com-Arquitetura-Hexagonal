package com.pinhobrunodev.userms.application.services;

import com.pinhobrunodev.userms.application.domain.UserDomain;
import com.pinhobrunodev.userms.application.ports.UserPersistencePort;
import com.pinhobrunodev.userms.application.ports.UserProducerPort;
import com.pinhobrunodev.userms.application.ports.UserServicePort;

public class UserServicePortImpl implements UserServicePort {

    final UserProducerPort userProducerPort;
    final UserPersistencePort userPersistencePort;

    public UserServicePortImpl(UserProducerPort userProducerPort, UserPersistencePort userPersistencePort) {
        this.userProducerPort = userProducerPort;
        this.userPersistencePort = userPersistencePort;
    }
    @Override
    public UserDomain saveUser(UserDomain userDomain) {
        return userPersistencePort.save(userDomain);
    }
    @Override
    public void producerUserEventAndSend(UserDomain userDomain) {
        userProducerPort.producerUserEventAndSend(userDomain);
    }
}
