package org.example.schedule2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleAllFindResponse {

    private Long id;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ScheduleAllFindResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
