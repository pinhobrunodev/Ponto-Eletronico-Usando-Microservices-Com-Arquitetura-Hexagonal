package com.pinhobrunodev.attendancems.frameworks.adapters.inbound.consumers;

import com.google.gson.Gson;
import com.pinhobrunodev.attendancems.application.domains.UserDomain;
import com.pinhobrunodev.attendancems.application.ports.user.UserServicePort;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserConsumer {


    final UserServicePort userServicePort;

    public UserConsumer(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @KafkaListener(topics = "${topic.name.consumer}")
    public void userListen(ConsumerRecord<String, String> payload){
        log.info("Message Received :{} ",payload);
        final Gson gson = new Gson();
        var userDomain = gson.fromJson(payload.value(), UserDomain.class);
        userServicePort.saveUserDomainFromConsumer(userDomain);
    }
}
