package com.pinhobrunodev.userms.application.ports;

import com.pinhobrunodev.userms.application.domain.UserDomain;

public interface UserPersistencePort {

    UserDomain save(UserDomain userDomain);

}
