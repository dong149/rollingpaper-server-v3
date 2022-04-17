package com.rollingpaper.api.controller;

import com.rollingpaper.api.model.dto.response.CountResponseDto;
import com.rollingpaper.api.service.CountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/count")
public class CountController {

    private final CountService countService;

    @GetMapping
    public ResponseEntity<CountResponseDto> getCount() {
        return ResponseEntity.status(HttpStatus.OK).body(countService.getCount());
    }
}
