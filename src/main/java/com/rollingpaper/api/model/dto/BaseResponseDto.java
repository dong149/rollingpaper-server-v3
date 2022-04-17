package com.rollingpaper.api.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BaseResponseDto {

    private int status;
    private String message;

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object object;

    @Builder
    public BaseResponseDto(int status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }
}
