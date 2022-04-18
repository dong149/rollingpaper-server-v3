package com.rollingpaper.api.utils;

import org.apache.commons.lang3.StringUtils;

public final class ImageUtils {

    public static String CDN_URL = "https://cdn.rollingpaper.site/";

    public static String detachCdnAddress(String imageUrl) {
        if (StringUtils.isEmpty(imageUrl) || !imageUrl.contains(CDN_URL)) {
            return null;
        }
        return imageUrl.replace(CDN_URL, "/");
    }
}
