package org.example.schedule2.schedule.dto;

import lombok.Getter;

@Getter
public class SaveScheduleRequest {

    private String title;
    private String content;
    private String userName;
    private String password;
}
