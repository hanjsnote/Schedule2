package org.example.schedule2.dto;

import lombok.Getter;

@Getter
public class ModifyScheduleResponse {

    private final String title;
    private final String name;

    public ModifyScheduleResponse(String title, String name){
        this.title = title;
        this.name = name;

    }

}
