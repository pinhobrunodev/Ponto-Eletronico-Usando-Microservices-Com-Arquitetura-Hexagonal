package com.pinhobrunodev.attendancems.application.ports;

import com.pinhobrunodev.attendancems.application.domains.UserDomain;

public interface UserServicePort {

    void saveUserDomainFromConsumer(UserDomain userDomain);
}
