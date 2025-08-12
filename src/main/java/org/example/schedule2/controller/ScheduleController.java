package org.example.schedule2.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.dto.*;
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
    public ResponseEntity<List<ScheduleAllFindResponse>> findAllSchedule(@RequestParam(required = false) String name){
        return ResponseEntity.ok(scheduleService.findsAll(name));
    }

    //일정 단건 조회
    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleSingleFindResponse> findSingleSchedule(@PathVariable long id){
        return ResponseEntity.ok(scheduleService.singleFind(id));
    }

    //일정 수정
    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleModifyResponse> modifySchedule(@PathVariable long id, @RequestBody ScheduleModifyRequest request){
        return ResponseEntity.ok(scheduleService.modifySchedule(id, request));
    }

}
