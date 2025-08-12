package org.example.schedule2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String name;
    private String password;

    public Schedule(String title, String content, String name, String password){
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    public void modifySchedule(String title, String name){
        this.title = title;
        this.name = name;
    }
}
