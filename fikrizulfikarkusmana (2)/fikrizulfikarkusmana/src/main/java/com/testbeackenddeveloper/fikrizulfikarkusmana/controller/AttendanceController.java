package com.testbeackenddeveloper.fikrizulfikarkusmana.controller;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.Attendance;
import com.testbeackenddeveloper.fikrizulfikarkusmana.service.AttendanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@Api(value = "Attendance Management System", tags = "Attendance Management")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @ApiOperation(value = "View a list of all attendances", response = List.class)
    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @ApiOperation(value = "Get attendance by ID", response = Attendance.class)
    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @ApiOperation(value = "Create a new attendance", response = Attendance.class)
    @PostMapping
    public Attendance createAttendance(@RequestBody Long userId) {
        return attendanceService.saveAttendance(userId);
    }

    @ApiOperation(value = "Delete an attendance")
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
}
