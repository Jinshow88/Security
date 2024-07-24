package com.green.greengram.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class FeedPics extends CreatedAt{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedPicId;

    @ManyToOne
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Column(length = 500, nullable = false)
    private String pic;

}
