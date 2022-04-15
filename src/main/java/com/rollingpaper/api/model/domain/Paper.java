package com.rollingpaper.api.model.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paper extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String font;
    private String sort;
    private String align;
    private String color;
    private String content;
    private String backgroundColor;
    private String backGroundImage;
    private String author;
    private LocalDateTime deletedAt;
    private long rollId;
    private Long userIdx;
    private boolean anonymous = true;
}
