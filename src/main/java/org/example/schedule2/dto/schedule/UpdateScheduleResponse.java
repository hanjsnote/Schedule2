package org.example.schedule2.dto.dtoSchedule;

import lombok.Getter;

@Getter
public class UpdateScheduleResponse {

    private final String title;
    private final String content;
    private final String name;

    public UpdateScheduleResponse(String title, String content, String name){
        this.title = title;
        this.content = content;
        this.name = name;


    }

}
