package com.pinhobrunodev.attendancems.application.ports;

import com.pinhobrunodev.attendancems.application.domains.UserDomain;

public interface UserPersistencePort {

    void save(UserDomain userDomain);
}
