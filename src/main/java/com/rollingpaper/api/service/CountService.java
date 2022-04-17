package com.rollingpaper.api.service;

import com.rollingpaper.api.model.dto.response.CountResponseDto;
import com.rollingpaper.api.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountService {

    private final PaperRepository paperRepository;

    public CountResponseDto getCount() {
        return new CountResponseDto(paperRepository.count());
    }

}
