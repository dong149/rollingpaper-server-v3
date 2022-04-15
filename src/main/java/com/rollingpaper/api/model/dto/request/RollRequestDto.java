package com.rollingpaper.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RollRequestDto {

    private String title;
    private Integer templateId;
}
