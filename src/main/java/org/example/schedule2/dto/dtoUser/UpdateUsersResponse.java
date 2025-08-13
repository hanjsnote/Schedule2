package org.example.schedule2.dtoUser;

import lombok.Getter;

@Getter
public class UpdateUsersResponse {

    private final String userName;
    private final String userEmail;

    public UpdateUsersResponse(String userName, String userEmail){
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
