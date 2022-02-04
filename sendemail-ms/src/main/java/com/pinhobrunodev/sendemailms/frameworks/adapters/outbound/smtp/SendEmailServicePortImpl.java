package com.pinhobrunodev.sendemailms.frameworks.adapters.outbound.smtp;

import com.pinhobrunodev.sendemailms.application.domains.EmailDomain;
import com.pinhobrunodev.sendemailms.application.ports.SendEmailServicePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendEmailServicePortImpl implements SendEmailServicePort {

    final JavaMailSender javaMailSender;

    public SendEmailServicePortImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(EmailDomain emailDomain) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailDomain.getEmailFrom());
        message.setTo(emailDomain.getEmailTo());
        message.setSubject(emailDomain.getSubject());
        message.setText(emailDomain.getText());
        javaMailSender.send(message);
    }
}
