package com.rollingpaper.api.model.domain.key;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Embeddable
public class TemplateStickerId implements Serializable {
    private Integer templateId;
    private Long stickerId;
}
