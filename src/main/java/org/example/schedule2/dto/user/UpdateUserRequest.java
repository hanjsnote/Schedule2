package org.example.schedule2.dto.dtoUser;

import lombok.Getter;

@Getter
public class UpdateUserRequest {

    private String userName;
    private String userPassword;
    private String userEmail;
}
