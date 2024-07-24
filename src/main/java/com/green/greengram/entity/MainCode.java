package com.green.greengram.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Entity
public class MainCode {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MainCodeId;

    @Column(length = 20, nullable = false)
    private String cdName;

    @Column(length = 30)
    private String description;
}
