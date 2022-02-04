package com.pinhobrunodev.sendemailms.application.ports;

import com.pinhobrunodev.sendemailms.application.domains.EmailDomain;

public interface EmailPersistencePort {

    void save(EmailDomain emailDomain);
}
