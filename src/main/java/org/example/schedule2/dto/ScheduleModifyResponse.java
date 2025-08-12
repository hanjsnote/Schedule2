package org.example.schedule2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleModifyResponse {

    private final String title;
    private final String name;

    public ScheduleModifyResponse(String title, String name){
        this.title = title;
        this.name = name;

    }

}
