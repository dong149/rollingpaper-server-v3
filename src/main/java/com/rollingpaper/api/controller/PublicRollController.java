package com.rollingpaper.api.controller;

import com.rollingpaper.api.model.dto.BaseResponseDto;
import com.rollingpaper.api.service.PublicRollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/publicRolls")
public class PublicRollController {

    private final PublicRollService publicRollService;

    @GetMapping
    public ResponseEntity<BaseResponseDto> getPublicRollInfo() {
        return ResponseEntity.ok().body(
            BaseResponseDto.builder()
                           .status(HttpStatus.OK.value())
                           .message("데이터 조회 성공")
                           .object(publicRollService.getPublicRollInfo())
                           .build());
    }
}
