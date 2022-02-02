package com.pinhobrunodev.userms.application.ports;

import com.pinhobrunodev.userms.application.domain.UserDomain;

public interface UserServicePort {

    UserDomain saveUser(UserDomain userDomain);
    void producerUserEventAndSend(UserDomain userDomain);


}
