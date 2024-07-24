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
                        columnNames = {"user_id", "role_cd"}
                )
        }
)
public class UserRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

   @ManyToOne
   @JoinColumn(name = "role_cd", nullable = false)
   private SubCode subCode;

    @Column(length = 20, nullable = false)
    private String role;
}
