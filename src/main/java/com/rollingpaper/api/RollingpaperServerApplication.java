package com.rollingpaper.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RollingpaperServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RollingpaperServerApplication.class, args);
    }

}
