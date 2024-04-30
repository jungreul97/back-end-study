package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.notice.Notice;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class NoticeResponseDto {
    private Long noticeIdx;
    private String noticeTitle;
    private String noticeContent;
    private String noticeMemberId;
    private LocalDate noticeDate;

    public NoticeResponseDto(Notice entity) {
        this.noticeIdx = entity.getNoticeIdx();
        this.noticeTitle = entity.getNoticeTitle();
        this.noticeContent = entity.getNoticeContent();
        this.noticeMemberId = entity.getNoticeMemberId();
        this.noticeDate = entity.getNoticeDate();
    }


}
