package com.rollingpaper.api.service;

import com.rollingpaper.api.model.domain.Sticker;
import com.rollingpaper.api.repository.StickerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StickerService {

    private final StickerRepository stickerRepository;

    public List<Sticker> createStickers(List<Sticker> stickers) {
        return stickerRepository.saveAll(stickers);
    }
}
