package com.green.greengram.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(//유니크
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"from_user_id", "to_user_id"}
                )
        }
)
public class UserFollow extends CreatedAt{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userFollowId;

    @ManyToOne//Many(Userfollow) One(User)
    @JoinColumn(name = "from_user_id")// 조인 컬럼명(컬럼명이 됨)
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;
//    @JoinColumn(name = "to_user_id",unique = true) 혼자 유니크 걸때 사용

}
