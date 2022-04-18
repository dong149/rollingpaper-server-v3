package com.rollingpaper.api.model.dto.request;

import com.rollingpaper.api.model.domain.Sticker;
import com.rollingpaper.api.utils.ImageUtils;
import java.util.HashSet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Getter
@NoArgsConstructor
public class StickerRequestDto {

    private String imageUrl;

    public Sticker toEntity() {
        String imageKey = ImageUtils.detachCdnAddress(imageUrl);

        if (StringUtils.isEmpty(imageKey)) {
            throw new IllegalArgumentException(String.format("Invalid 'imageKey'. imageUrl: %s", imageKey));
        }

        return Sticker.builder()
                      .imageKey(imageKey)
                      .templateStickers(new HashSet<>())
                      .build();
    }


}
