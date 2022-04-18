package com.rollingpaper.api.model.domain;

import com.rollingpaper.api.model.domain.key.TemplateStickerId;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TemplateSticker {

    @EmbeddedId
    private TemplateStickerId templateStickerId;

    @ManyToOne
    @MapsId("templateId")
    @JoinColumn(name = "template_id")
    private Template template;

    @ManyToOne
    @MapsId("stickerId")
    @JoinColumn(name = "sticker_id")
    private Sticker sticker;
}
