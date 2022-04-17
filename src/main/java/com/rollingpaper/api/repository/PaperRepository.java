package com.rollingpaper.api.repository;

import com.rollingpaper.api.model.domain.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepository extends JpaRepository<Paper, Long> {

    Integer countByRollIdAndDeletedAtIsNull(long rollId);
}
