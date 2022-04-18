package com.rollingpaper.api.controller;

import com.rollingpaper.api.model.domain.Sticker;
import com.rollingpaper.api.model.dto.request.StickerRequestDto;
import com.rollingpaper.api.service.StickerService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/stickers")
public class StickerController {

    private final StickerService stickerService;

    @PostMapping
    public ResponseEntity<Void> createStickers(@RequestBody List<StickerRequestDto> requestDtos) {
        List<Sticker> stickers = requestDtos.stream()
                                            .map(StickerRequestDto::toEntity)
                                            .collect(Collectors.toList());

        stickerService.createStickers(stickers);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
