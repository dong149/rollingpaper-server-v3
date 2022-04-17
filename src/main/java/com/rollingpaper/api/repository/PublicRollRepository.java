package com.rollingpaper.api.repository;

import com.rollingpaper.api.model.domain.PublicRoll;
import com.rollingpaper.api.model.domain.Roll;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicRollRepository extends JpaRepository<PublicRoll, Long> {

    List<PublicRoll> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    Optional<PublicRoll> findByRoll(Roll roll);
}
