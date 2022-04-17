package com.rollingpaper.api.model.dto.response;

import com.rollingpaper.api.model.domain.Roll;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RollResponseDto {

    private Long rollId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer templateId;
    private Integer paperCount;

    public static RollResponseDto from(Roll roll) {
        return RollResponseDto.builder()
                              .rollId(roll.getId())
                              .createdAt(roll.getCreatedAt())
                              .updatedAt(roll.getUpdatedAt())
                              .build();
    }

    public static RollResponseDto of(Roll roll, Integer paperCount) {
        return RollResponseDto.builder()
                              .rollId(roll.getId())
                              .paperCount(paperCount)
                              .build();
    }
}
