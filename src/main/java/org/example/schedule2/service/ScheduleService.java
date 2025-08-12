package org.example.schedule2.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.dto.ScheduleAllFindResponse;
import org.example.schedule2.dto.ScheduleSaveRequest;
import org.example.schedule2.dto.ScheduleSaveResponse;
import org.example.schedule2.entity.Schedule;
import org.example.schedule2.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public ScheduleSaveResponse saveSchedule(ScheduleSaveRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getName(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleSaveResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

}
