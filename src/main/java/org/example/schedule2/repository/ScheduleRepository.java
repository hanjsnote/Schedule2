package org.example.schedule2.repository;

import org.example.schedule2.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByOrderByIdDesc(); //수정일 기준 내림차순 정렬

    Schedule findById(Schedule id);
}
