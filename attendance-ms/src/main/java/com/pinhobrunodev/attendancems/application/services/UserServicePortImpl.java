package com.pinhobrunodev.attendancems.application.services;

import com.pinhobrunodev.attendancems.application.domains.UserDomain;
import com.pinhobrunodev.attendancems.application.ports.user.UserPersistencePort;
import com.pinhobrunodev.attendancems.application.ports.user.UserServicePort;

import java.util.UUID;

public class UserServicePortImpl implements UserServicePort {

    final UserPersistencePort userPersistencePort;

    public UserServicePortImpl(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUserDomainFromConsumer(UserDomain userDomain) {
        userPersistencePort.save(userDomain);
    }

    @Override
    public UserDomain findByUUID(UUID userId) {
        return userPersistencePort.findByUserUUID(userId);
    }
}
