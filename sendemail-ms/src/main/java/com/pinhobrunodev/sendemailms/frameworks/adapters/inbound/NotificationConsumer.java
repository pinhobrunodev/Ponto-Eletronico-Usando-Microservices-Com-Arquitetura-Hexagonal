package com.pinhobrunodev.sendemailms.frameworks.adapters.inbound;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinhobrunodev.sendemailms.application.domains.EmailDomain;
import com.pinhobrunodev.sendemailms.application.ports.EmailServicePort;
import com.pinhobrunodev.sendemailms.frameworks.adapters.dto.NotificationCommandDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {

    final ModelMapper modelMapper;
    final EmailServicePort emailServicePort;
    final ObjectMapper objectMapper;

    public NotificationConsumer(ModelMapper modelMapper, EmailServicePort emailServicePort, ObjectMapper objectMapper) {
        this.modelMapper = modelMapper;
        this.emailServicePort = emailServicePort;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${notification.broker.queue.notificationCommandQueue}", durable = "true"),
            exchange = @Exchange(value = "${notification.broker.exchange}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${notification.broker.key.notificationCommandKey}"
    ))
    public void listenNotificationEvent(@Payload NotificationCommandDto notificationCommandDto) {
        log.info("Notification received payload : {}", notificationCommandDto);
        var emailDomain = new EmailDomain(null,notificationCommandDto.getFullName(),"brunopinho1010@gmail.com",notificationCommandDto.getEmail(),"SISTEMA DE PONTO ELETRÔNICO",notificationCommandDto.getMessage(),null);
        log.info("EmailDomain after set the event : {}",emailDomain);
        emailServicePort.saveEmail(emailDomain);
        emailServicePort.sendEmailSmtp(emailDomain);
        log.info("Email sent payload : {}", emailDomain);

    }


}
