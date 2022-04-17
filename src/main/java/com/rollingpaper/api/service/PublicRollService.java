package com.rollingpaper.api.service;

import com.rollingpaper.api.exception.InvalidRequestException;
import com.rollingpaper.api.exception.NotExistContentException;
import com.rollingpaper.api.model.domain.PublicRoll;
import com.rollingpaper.api.model.domain.Roll;
import com.rollingpaper.api.model.dto.response.PublicRollInfoResponseDto;
import com.rollingpaper.api.model.dto.response.PublicRollInfoResponseDto.PublicRollInfo;
import com.rollingpaper.api.repository.PublicRollRepository;
import com.rollingpaper.api.repository.RollRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublicRollService {

    private static final int PUBLIC_ROLL_DURATION = 7;
    private static final String WEB_BASE_URL = "http://test.com";

    private final RollRepository rollRepository;
    private final PublicRollRepository publicRollRepository;

    @Transactional(readOnly = true)
    public PublicRollInfoResponseDto getPublicRollInfo() {
        LocalDateTime from = LocalDateTime.now().minusDays(PUBLIC_ROLL_DURATION);
        LocalDateTime to = LocalDateTime.now();
        List<PublicRoll> publicRolls = publicRollRepository.findByCreatedAtBetween(from, to);

        List<PublicRollInfo> publicRollInfos = publicRolls.stream()
                                                          .map(publicRoll -> {
                                                              Roll roll = publicRoll.getRoll();
                                                              long paperCount = roll.getPapers().size();
                                                              return PublicRollInfo.of(
                                                                  roll, WEB_BASE_URL, paperCount);
                                                          })
                                                          .filter(publicRollInfo -> publicRollInfo.getPaperCount() > 0)
                                                          .collect(Collectors.toList());

        return PublicRollInfoResponseDto.from(publicRollInfos);
    }

    @Transactional
    public void savePublicRoll(Long rollId) {
        Roll roll = rollRepository.findById(rollId).orElseThrow(() -> {
            throw new NotExistContentException("not exist roll");
        });

        publicRollRepository.findByRoll(roll).ifPresent(registeredRoll -> {
            log.warn("already registered rollId : {}", registeredRoll.getId());
            throw new InvalidRequestException("already registered roll id");
        });

        publicRollRepository.save(PublicRoll.from(roll));
    }
}
