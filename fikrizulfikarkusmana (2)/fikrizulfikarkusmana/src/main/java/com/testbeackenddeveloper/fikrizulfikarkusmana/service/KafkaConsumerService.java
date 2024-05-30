// KafkaConsumerService.java
package com.testbeackenddeveloper.fikrizulfikarkusmana.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "attendance-topic", groupId = "group_id")
    public void listenAttendance(String message) {
        System.out.println("Received attendance message: " + message);
    }

    @KafkaListener(topics = "mata-pelajaran-topic", groupId = "group_id")
    public void listenMataPelajaran(String message) {
        System.out.println("Received mata pelajaran message: " + message);
    }

    @KafkaListener(topics = "user-topic", groupId = "group_id")
    public void listenUser(String message) {
        System.out.println("Received user message: " + message);
    }

    @KafkaListener(topics = "penilaian-topic", groupId = "group_id")
    public void listenPenilaian(String message) {
        System.out.println("Received penilaian message: " + message);
    }
}
