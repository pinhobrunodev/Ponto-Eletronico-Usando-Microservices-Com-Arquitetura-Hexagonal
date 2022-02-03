package com.pinhobrunodev.notificationms.frameworks.adapters.outbound.producer;

import com.google.gson.Gson;
import com.pinhobrunodev.notificationms.application.domain.NotificationDomain;
import com.pinhobrunodev.notificationms.application.ports.NotificationProducerPort;
import com.pinhobrunodev.notificationms.frameworks.adapters.dto.NotificationEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class NotificationProducerPortImpl implements NotificationProducerPort {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    @Value(value = "${notification.broker.exchange.notificationCommandExchange}")
    private String notificationCommandExchange;
    @Value(value = "${notification.broker.key.notificationCommandKey}")
    private String notificationCommandKey;


    @Override
    public void producerNotificationEventAndSend(NotificationDomain notificationDomain) {
        final Gson gson = new Gson();
        var notificationEvent = NotificationEventDto.builder()
                .userId(notificationDomain.getUserId())
                .fullName(notificationDomain.getFullName())
                .email(notificationDomain.getEmail())
                .message(notificationDomain.getMessage())
                .attendanceAt(notificationDomain.getAttendanceAt());
        log.info("Message sent payload : {}", notificationEvent);
        rabbitTemplate.convertAndSend(notificationCommandExchange, notificationCommandKey, gson.toJson(notificationEvent));
    }
}
