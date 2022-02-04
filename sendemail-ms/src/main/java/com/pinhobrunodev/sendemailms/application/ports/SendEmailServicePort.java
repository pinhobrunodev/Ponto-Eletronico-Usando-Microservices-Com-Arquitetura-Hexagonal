package com.pinhobrunodev.sendemailms.application.ports;

import com.pinhobrunodev.sendemailms.application.domains.EmailDomain;

public interface SendEmailServicePort {

    void sendEmail(EmailDomain emailDomain);
}
