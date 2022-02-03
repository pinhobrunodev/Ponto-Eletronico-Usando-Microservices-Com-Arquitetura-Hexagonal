package com.pinhobrunodev.notificationms.frameworks.adapters.inbound.consumer;

import com.google.gson.Gson;
import com.pinhobrunodev.notificationms.application.domain.NotificationDomain;
import com.pinhobrunodev.notificationms.application.ports.NotificationServicePort;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AttendanceConsumer {


    final NotificationServicePort notificationServicePort;

    public AttendanceConsumer(NotificationServicePort notificationServicePort) {
        this.notificationServicePort = notificationServicePort;
    }
    @KafkaListener(topics = "${topic.name.consumer}")
    public void userListen(ConsumerRecord<String, String> payload){
        log.info("Message Received :{} ",payload);
        final Gson gson = new Gson();
        var notificationDomain = gson.fromJson(payload.value(), NotificationDomain.class);
        notificationServicePort.saveNotification(notificationDomain);
    }
}
