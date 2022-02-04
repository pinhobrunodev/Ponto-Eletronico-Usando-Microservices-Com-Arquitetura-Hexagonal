package com.pinhobrunodev.sendemailms.application.ports;

import com.pinhobrunodev.sendemailms.application.domains.EmailDomain;

public interface EmailServicePort {

    void sendEmailSmtp(EmailDomain emailDomain);
    void saveEmail(EmailDomain emailDomain);
}
