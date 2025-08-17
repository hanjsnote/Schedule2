package org.example.schedule2.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.schedule.dto.*;
import org.example.schedule2.schedule.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping("/schedules")
    public ResponseEntity<SaveScheduleResponse> saveSchedule(@RequestBody SaveScheduleRequest request){
        return ResponseEntity.ok(scheduleService.saveSchedule(request));
    }

    //일정 조회
    @GetMapping("/schedules")
    public ResponseEntity<List<FindAllScheduleResponse>> findAllSchedule(@RequestParam(required = false) String name){
        return ResponseEntity.ok(scheduleService.findsAll(name));
    }

    //일정 단건 조회
    @GetMapping("/schedules/{id}")
    public ResponseEntity<SingleFindSchedulesResponse> findSingleSchedule(@PathVariable long id){
        return ResponseEntity.ok(scheduleService.singleFind(id));
    }

    //일정 수정
    @PutMapping("/schedules/{id}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable long id, @RequestBody UpdateScheduleRequest request){
        return ResponseEntity.ok(scheduleService.updateSchedule(id, request));
    }

    //일정 삭제
    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable long id){
        scheduleService.deleteSchedule(id);
    }

}
