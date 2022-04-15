package com.rollingpaper.api.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Template extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int templateId;
    private String name;
    private String description;
    private String rollCss;
    private String thumbnailImageKey;
    private boolean isDefault = false;
}
