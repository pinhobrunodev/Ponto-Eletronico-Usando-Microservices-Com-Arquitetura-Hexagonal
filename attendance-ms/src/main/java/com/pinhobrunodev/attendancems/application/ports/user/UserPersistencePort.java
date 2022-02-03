package com.pinhobrunodev.attendancems.application.ports.user;

import com.pinhobrunodev.attendancems.application.domains.UserDomain;

public interface UserPersistencePort {

    void save(UserDomain userDomain);
}
