package com.pinhobrunodev.notificationms.frameworks.adapters.outbound.producer;

import com.pinhobrunodev.notificationms.application.domain.NotificationDomain;
import com.pinhobrunodev.notificationms.application.ports.NotificationProducerPort;
import com.pinhobrunodev.notificationms.frameworks.adapters.dto.NotificationCommandDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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

    final ModelMapper modelMapper;

    @Override
    public void producerNotificationEventAndSend(NotificationDomain notificationDomain) {
        var notificationCommandDto = modelMapper.map(notificationDomain, NotificationCommandDto.class);
        log.info("Message sent payload : {}", notificationCommandDto);
        rabbitTemplate.convertAndSend(notificationCommandExchange, notificationCommandKey, notificationCommandDto);
    }
}
