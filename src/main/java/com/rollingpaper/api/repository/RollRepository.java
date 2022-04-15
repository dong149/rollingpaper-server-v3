package com.rollingpaper.api.repository;

import com.rollingpaper.api.model.domain.Roll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RollRepository extends JpaRepository<Roll, Long> {
}
