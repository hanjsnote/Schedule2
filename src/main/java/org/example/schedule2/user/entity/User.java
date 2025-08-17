package org.example.schedule2.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.schedule2.schedule.entity.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userPassword;
    private String userEmail;

    public User(String userName, String userPassword, String userEmail){
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public void updateUser(String userName, String userEmail){
        this.userName = userName;
        this.userEmail = userEmail;
    }

}
