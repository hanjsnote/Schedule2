package org.example.schedule2.dtoSchedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SingleFindSchedulesResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public SingleFindSchedulesResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
