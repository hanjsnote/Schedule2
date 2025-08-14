package org.example.schedule2.dto.user;

import lombok.Getter;

@Getter
public class SaveUserRequest {

    private String userName;
    private String userPassword;
    private String userEmail;
}
