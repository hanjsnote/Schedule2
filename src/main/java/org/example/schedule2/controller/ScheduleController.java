package org.example.schedule2.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.dto.ScheduleAllFindResponse;
import org.example.schedule2.dto.ScheduleSaveRequest;
import org.example.schedule2.dto.ScheduleSaveResponse;
import org.example.schedule2.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponse> saveSchedule(@RequestBody ScheduleSaveRequest request){
        return ResponseEntity.ok(scheduleService.saveSchedule(request));
    }

}
