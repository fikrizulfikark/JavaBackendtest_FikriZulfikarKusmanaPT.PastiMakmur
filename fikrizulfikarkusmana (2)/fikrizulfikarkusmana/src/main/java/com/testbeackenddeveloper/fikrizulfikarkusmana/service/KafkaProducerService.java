// KafkaProducerService.java
package com.testbeackenddeveloper.fikrizulfikarkusmana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendAttendanceMessage(String message) {
        kafkaTemplate.send("attendance-topic", message);
    }

    public void sendMataPelajaranMessage(String message) {
        kafkaTemplate.send("mata-pelajaran-topic", message);
    }

    public void sendUserMessage(String message) {
        kafkaTemplate.send("user-topic", message);
    }

    public void sendPenilaianMessage(String message) {
        kafkaTemplate.send("penilaian-topic", message);
    }
}
