package com.rollingpaper.api.repository;

import com.rollingpaper.api.model.domain.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, Integer> {

}
