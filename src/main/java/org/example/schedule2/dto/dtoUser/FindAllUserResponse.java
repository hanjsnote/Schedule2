package org.example.schedule2.dtoUser;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FindAllUserResponse {

    private final Long userId;
    private final String userName;
    private final String userEmail;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public FindAllUserResponse(Long userId, String userName, String userEmail, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
