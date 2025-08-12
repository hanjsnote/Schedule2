package org.example.schedule2.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.dto.ScheduleAllFindResponse;
import org.example.schedule2.dto.ScheduleSaveRequest;
import org.example.schedule2.dto.ScheduleSaveResponse;
import org.example.schedule2.dto.ScheduleSingleFindResponse;
import org.example.schedule2.entity.Schedule;
import org.example.schedule2.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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

    //일정 조회
    @Transactional(readOnly = true)
    public List<ScheduleAllFindResponse> findsAll(String name) {

        List<Schedule> findAll = scheduleRepository.findAll();
        List<ScheduleAllFindResponse> dtos = new ArrayList<>();

        if(name == null){
            for(Schedule schedule : findAll){
                dtos.add(new ScheduleAllFindResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getName(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ));
            }
            return dtos;
        }
        for(Schedule schedule : findAll){
            if(name.equals(schedule.getName())){
                dtos.add(new ScheduleAllFindResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getName(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ));
            }
        }
        return dtos;
    }

    public ScheduleSingleFindResponse singleFind(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id의 일정이 없습니다.")
        );

        return new ScheduleSingleFindResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }
}
