package com.rollingpaper.api.repository;

import com.rollingpaper.api.model.domain.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StickerRepository extends JpaRepository<Sticker, Long> {

}
