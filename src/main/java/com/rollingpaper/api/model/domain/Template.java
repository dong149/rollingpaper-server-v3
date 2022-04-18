package com.rollingpaper.api.model.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Template extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int templateId;
    private String name;
    private String description;
    private String rollCss;
    private String thumbnailImageKey;
    private boolean isDefault = false;
    @OneToMany(mappedBy = "template", fetch = FetchType.LAZY)
    private List<TemplateSticker> templateStickers;
}
