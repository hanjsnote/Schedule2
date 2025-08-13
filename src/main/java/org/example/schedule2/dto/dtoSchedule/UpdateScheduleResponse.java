package org.example.schedule2.dto.dtoSchedule;

import lombok.Getter;

@Getter
public class UpdateSchedulesResponse {

    private final String title;
    private final String name;

    public UpdateSchedulesResponse(String title, String name){
        this.title = title;
        this.name = name;

    }

}
