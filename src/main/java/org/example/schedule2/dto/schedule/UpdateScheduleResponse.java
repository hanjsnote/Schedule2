package org.example.schedule2.dto.schedule;

import lombok.Getter;

@Getter
public class UpdateScheduleResponse {

    private final String title;
    private final String content;

    public UpdateScheduleResponse(String title, String content){
        this.title = title;
        this.content = content;

    }

}
