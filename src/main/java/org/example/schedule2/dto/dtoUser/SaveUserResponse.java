package org.example.schedule2.dto.dtoUser;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SaveUsersResponse {

    private final Long userId;
    private final String userName;
    private final String userEmail;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public SaveUsersResponse(Long userId, String userName, String userEmail, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
