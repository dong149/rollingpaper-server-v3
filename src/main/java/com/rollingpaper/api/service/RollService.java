package com.rollingpaper.api.service;

import com.rollingpaper.api.exception.NotExistContentException;
import com.rollingpaper.api.model.domain.Roll;
import com.rollingpaper.api.model.domain.Template;
import com.rollingpaper.api.model.dto.request.RollRequestDto;
import com.rollingpaper.api.model.dto.response.RollResponseDto;
import com.rollingpaper.api.repository.PaperRepository;
import com.rollingpaper.api.repository.RollRepository;
import com.rollingpaper.api.repository.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RollService {

    private final RollRepository rollRepository;
    private final PaperRepository paperRepository;
    private final TemplateRepository templateRepository;

    @Transactional
    public RollResponseDto createRoll(RollRequestDto requestDto) {
        Template template = templateRepository.findById(requestDto.getTemplateId()).orElseThrow(() -> {
            throw new NotExistContentException("not exist template");
        });

        Roll roll = Roll.builder()
                        .title(requestDto.getTitle())
                        .template(template)
                        .userIdx(0L)
                        .build();

        rollRepository.save(roll);

        return RollResponseDto.from(roll);
    }

    @Transactional(readOnly = true)
    public RollResponseDto getRollResponseDto(Long id) {
        Roll roll = findRoll(id);
        Integer paperCount = paperRepository.countByRollIdAndDeletedAtIsNull(roll.getId());

        return RollResponseDto.of(roll, paperCount);
    }

    private Roll findRoll(Long id) {
        Roll roll = rollRepository.findById(id).orElseThrow(() -> {
            throw new NotExistContentException("not exist roll");
        });

        if (roll.getDeletedAt() != null) {
            throw new NotExistContentException("deleted content");
        }

        return roll;
    }
}
