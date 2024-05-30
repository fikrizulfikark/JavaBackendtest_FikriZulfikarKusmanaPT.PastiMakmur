package com.testbeackenddeveloper.fikrizulfikarkusmana.service;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.Attendance;
import com.testbeackenddeveloper.fikrizulfikarkusmana.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance saveAttendance(Long userId) {
        Attendance attendance = new Attendance();
        attendance.setUserId(userId);
        attendance.setTimestamp(LocalDateTime.now());
        Attendance savedAttendance = attendanceRepository.save(attendance);
        kafkaProducerService.sendAttendanceMessage("Created Attendance with ID: " + savedAttendance.getId() + " for user ID: " + savedAttendance.getUserId());
        return savedAttendance;
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
