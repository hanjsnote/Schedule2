package org.example.schedule2.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.schedule.entity.Schedule;
import org.example.schedule2.schedule.repository.ScheduleRepository;
import org.example.schedule2.schedule.dto.*;
import org.example.schedule2.user.entity.User;
import org.example.schedule2.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    //일정 생성
    public SaveScheduleResponse saveSchedule(SaveScheduleRequest request) {

//        User findUser = userRepository.findUserByUserIdOrElseThrow(request.getUserId());

       User findUser = userRepository.findById(request.getUserId()).orElseThrow(
               () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
       );

        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getPassword()
        );
        schedule.setUser(findUser);
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new SaveScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getUser().getUserName(),
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
                        schedule.getUser().getUserName(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ));
            }
            return dtos;
        }

        for(Schedule schedule : findAll){
            if(userName.equals(schedule.getUser().getUserName())){
                dtos.add(new FindAllScheduleResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getUser().getUserName(),
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
                schedule.getUser().getUserName(),
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
