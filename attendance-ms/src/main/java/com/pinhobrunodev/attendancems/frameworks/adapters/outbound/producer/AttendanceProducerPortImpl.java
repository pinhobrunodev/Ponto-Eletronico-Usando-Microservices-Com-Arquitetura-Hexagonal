package com.pinhobrunodev.attendancems.frameworks.adapters.outbound.producer;

import com.google.gson.Gson;
import com.pinhobrunodev.attendancems.application.domains.AttendanceDomain;
import com.pinhobrunodev.attendancems.application.ports.attendance.AttendanceProducerPort;
import com.pinhobrunodev.attendancems.frameworks.adapters.dto.AttendanceEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class AttendanceProducerPortImpl implements AttendanceProducerPort {


    @Value("${topic.name.producer}")
    private String topicName;


    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void producerAttendanceEventAndSend(AttendanceDomain attendanceDomain) {
        final Gson gson = new Gson();
        var attendanceEvent = AttendanceEventDto.builder()
                .userId(attendanceDomain.getUserId())
                .fullName(attendanceDomain.getFullName())
                .email(attendanceDomain.getEmail())
                .departmentType(attendanceDomain.getDepartmentType())
                .attendanceAt(attendanceDomain.getAttendanceAt());
        log.info("Message sent payload : {}", attendanceEvent);
        kafkaTemplate.send(topicName, gson.toJson(attendanceEvent));
    }
}
