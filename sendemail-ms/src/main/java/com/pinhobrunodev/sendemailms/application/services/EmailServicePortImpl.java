package com.pinhobrunodev.sendemailms.application.services;

import com.pinhobrunodev.sendemailms.application.domains.EmailDomain;
import com.pinhobrunodev.sendemailms.application.ports.EmailPersistencePort;
import com.pinhobrunodev.sendemailms.application.ports.EmailServicePort;
import com.pinhobrunodev.sendemailms.application.ports.SendEmailServicePort;


public class EmailServicePortImpl implements EmailServicePort {

    final EmailPersistencePort emailPersistencePort;
    final SendEmailServicePort sendEmailServicePort;

    public EmailServicePortImpl(EmailPersistencePort emailPersistencePort, SendEmailServicePort sendEmailServicePort) {
        this.emailPersistencePort = emailPersistencePort;
        this.sendEmailServicePort = sendEmailServicePort;
    }

    @Override
    public void sendEmailSmtp(EmailDomain emailDomain) {
        sendEmailServicePort.sendEmail(emailDomain);
    }

    @Override
    public void saveEmail(EmailDomain emailDomain) {
        emailPersistencePort.save(emailDomain);
    }
}
