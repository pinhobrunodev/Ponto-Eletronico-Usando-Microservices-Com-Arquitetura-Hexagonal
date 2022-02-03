package com.pinhobrunodev.attendancems.application.ports.user;

import com.pinhobrunodev.attendancems.application.domains.UserDomain;

import java.util.UUID;

public interface UserPersistencePort {

    void save(UserDomain userDomain);
    UserDomain findByUserUUID(UUID userId);
}
