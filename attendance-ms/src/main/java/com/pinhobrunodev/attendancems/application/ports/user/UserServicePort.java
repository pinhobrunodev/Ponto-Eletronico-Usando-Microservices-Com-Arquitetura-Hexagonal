package com.pinhobrunodev.attendancems.application.ports.user;

import com.pinhobrunodev.attendancems.application.domains.UserDomain;

import java.util.UUID;

public interface UserServicePort {

    void saveUserDomainFromConsumer(UserDomain userDomain);
    UserDomain findByUUID(UUID userId);
}
