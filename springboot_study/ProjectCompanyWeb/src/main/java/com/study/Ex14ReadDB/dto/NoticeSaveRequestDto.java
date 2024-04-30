package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.notice.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class NoticeSaveRequestDto {
    private String noticeTitle;
    private String noticeContent;
    private String noticeMemberId;
    private LocalDate noticeDate;

    @Builder

    public NoticeSaveRequestDto(String noticeTitle, LocalDate noticeDate, String noticeMemberId, String noticeContent) {
        this.noticeTitle = noticeTitle;
        this.noticeDate = noticeDate;
        this.noticeMemberId = noticeMemberId;
        this.noticeContent = noticeContent;
    }
    public Notice toEntity(){
        return Notice.builder()
                .noticeContent(this.noticeContent)
                .noticeDate(LocalDate.now())
                .noticeMemberId(this.noticeMemberId)
                .noticeTitle(this.noticeTitle)
                .build();
    }
}
