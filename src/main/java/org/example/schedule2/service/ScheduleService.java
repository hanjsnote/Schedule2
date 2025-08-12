package org.example.schedule2.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.dto.*;
import org.example.schedule2.entity.Schedule;
import org.example.schedule2.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
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

    //일정 단건 조회
    @Transactional(readOnly = true)
    public ScheduleSingleFindResponse singleFind(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다")
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

    //일정 수정
    public ScheduleModifyResponse modifySchedule(long id, ScheduleModifyRequest request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );

        if (request.getPassword() == null){
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }

        if (!schedule.getPassword().equals(request.getPassword())){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다!");
        }

        schedule.modifySchedule(
                request.getTitle(),
                request.getName()
        );

        return new ScheduleModifyResponse(
                schedule.getTitle(),
                schedule.getName()
        );
    }
}
