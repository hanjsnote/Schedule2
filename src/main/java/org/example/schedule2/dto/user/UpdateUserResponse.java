package org.example.schedule2.dto.user;

import lombok.Getter;

@Getter
public class UpdateUserResponse {

    private final String userName;
    private final String userEmail;

    public UpdateUserResponse(String userName, String userEmail){
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
