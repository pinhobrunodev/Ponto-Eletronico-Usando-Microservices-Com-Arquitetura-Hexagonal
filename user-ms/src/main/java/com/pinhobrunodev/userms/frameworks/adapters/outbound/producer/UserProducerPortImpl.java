package com.pinhobrunodev.userms.frameworks.adapters.outbound.producer;

import com.pinhobrunodev.userms.application.domain.UserDomain;
import com.pinhobrunodev.userms.application.ports.UserProducerPort;
import com.pinhobrunodev.userms.frameworks.adapters.dto.UserEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class UserProducerPortImpl implements UserProducerPort {

    @Value("${topic.name.producer}")
    private String topicName;


    private final KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void producerUserEventAndSend(UserDomain userDomain) {
        final Gson gson = new Gson();
        var userEvent = UserEvent.builder()
                .userId(userDomain.getUserId())
                .departmentType(userDomain.getDepartmentType().toString())
                .email(userDomain.getEmail())
                .fullName(userDomain.getFirstName() + " " + userDomain.getLastName());
        log.info("Payload enviado : {}",userEvent);
        kafkaTemplate.send(topicName, gson.toJson(userEvent));
    }
}