package com.green.greengram.entity;

import com.green.greengram.security.SignInProviderType;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity // 이 클래스는 entity (테이블) 이다
public class User extends UpdatedAt{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ColumnDefault("4")
    @Column(nullable = false)
    private SignInProviderType providerType;

    @Column(length = 50, nullable = false)
    private String uid;

    @Column(length = 100, nullable = false)
    private String upw;

    @Column(length = 50, nullable = false)
    private String nm;

    @Column(length = 200)
    private String pic;


}
