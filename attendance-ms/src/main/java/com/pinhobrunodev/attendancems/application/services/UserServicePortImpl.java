package com.pinhobrunodev.attendancems.application.services;

import com.pinhobrunodev.attendancems.application.domains.UserDomain;
import com.pinhobrunodev.attendancems.application.ports.user.UserPersistencePort;
import com.pinhobrunodev.attendancems.application.ports.user.UserServicePort;

public class UserServicePortImpl implements UserServicePort {

    final UserPersistencePort userPersistencePort;

    public UserServicePortImpl(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUserDomainFromConsumer(UserDomain userDomain) {
        userPersistencePort.save(userDomain);
    }
}
