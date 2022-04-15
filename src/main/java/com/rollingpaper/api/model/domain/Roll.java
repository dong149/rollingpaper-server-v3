package com.rollingpaper.api.model.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Roll extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDateTime deletedAt;
    private Long userIdx;
    private boolean isPublic = false;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "rollId")
    private List<Paper> papers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "templateId")
    private Template template;

    @Builder
    public Roll(
        String title, LocalDateTime deletedAt, Long userIdx, boolean isPublic,
        List<Paper> papers, Template template) {
        this.title = title;
        this.deletedAt = deletedAt;
        this.userIdx = userIdx;
        this.isPublic = isPublic;
        this.papers = papers;
        this.template = template;
    }
}
