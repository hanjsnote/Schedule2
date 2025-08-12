package org.example.schedule2.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.dto.ScheduleAllFindResponse;
import org.example.schedule2.dto.ScheduleSaveRequest;
import org.example.schedule2.dto.ScheduleSaveResponse;
import org.example.schedule2.dto.ScheduleSingleFindResponse;
import org.example.schedule2.entity.Schedule;
import org.example.schedule2.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponse> saveSchedule(@RequestBody ScheduleSaveRequest request){
        return ResponseEntity.ok(scheduleService.saveSchedule(request));
    }

    //일정 조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleAllFindResponse>> scheduleAllFind(@RequestParam(required = false) String name){
        return ResponseEntity.ok(scheduleService.findsAll(name));
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleSingleFindResponse> scheduleSingleFind(@PathVariable long id){
        return ResponseEntity.ok(scheduleService.singleFind(id));
    }

}
