package com.rollingpaper.api.controller;

import com.rollingpaper.api.model.dto.request.RollRequestDto;
import com.rollingpaper.api.model.dto.response.RollResponseDto;
import com.rollingpaper.api.service.RollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/rolls")
public class RollController {

    private final RollService rollService;

    @PostMapping
    public ResponseEntity<RollResponseDto> createRoll(@RequestBody RollRequestDto requestDto) {
        RollResponseDto responseDto = rollService.createRoll(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
