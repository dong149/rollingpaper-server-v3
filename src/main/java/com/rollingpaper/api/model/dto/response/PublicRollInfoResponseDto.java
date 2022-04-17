package com.rollingpaper.api.model.dto.response;

import com.rollingpaper.api.model.domain.Roll;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PublicRollInfoResponseDto {

    List<PublicRollInfo> publicRollInfoList;

    public static PublicRollInfoResponseDto from(List<PublicRollInfo> publicRollInfos) {
        return new PublicRollInfoResponseDto(publicRollInfos);
    }

    @Getter
    @NoArgsConstructor
    public static class PublicRollInfo {

        private static final String EDITABLE_TRUE = "?editable=true";

        private String url;
        private String title;
        private long paperCount;

        public PublicRollInfo(String url, String title, long paperCount) {
            this.url = url + EDITABLE_TRUE;
            this.title = title;
            this.paperCount = paperCount;
        }

        public static PublicRollInfo of(Roll roll, String baseUrl, long paperCount) {
            return new PublicRollInfo(
                baseUrl + "rolls/" + roll.getId(),
                roll.getTitle(),
                paperCount);
        }
    }
}
