package org.example.schedule2.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.schedule.entity.Schedule;
import org.example.schedule2.schedule.repository.ScheduleRepository;
import org.example.schedule2.schedule.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public SaveScheduleResponse saveSchedule(SaveScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getName(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new SaveScheduleResponse(
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
    public List<FindAllScheduleResponse> findsAll(String userName) {

        List<Schedule> findAll = scheduleRepository.findAll();
        List<FindAllScheduleResponse> dtos = new ArrayList<>();

        if(userName == null){
            for(Schedule schedule : findAll){
                dtos.add(new FindAllScheduleResponse(
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
            if(userName.equals(schedule.getName())){
                dtos.add(new FindAllScheduleResponse(
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
    public SingleFindSchedulesResponse singleFind(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다")
        );
        return new SingleFindSchedulesResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    //일정 수정
    public UpdateScheduleResponse updateSchedule(long id, UpdateScheduleRequest request) {
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
                request.getContent()
        );

        return new UpdateScheduleResponse(
                schedule.getTitle(),
                schedule.getContent()
        );
    }

    //일정 삭제
    public void deleteSchedule(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );
        scheduleRepository.deleteById(schedule.getId());
    }
}
