package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.qna.Qna;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class QnaRequestSavedto {
    private String qnaName;
    private String qnaPw;
    private String qnaTitle;
    private String qnaContent;
    private LocalDate qnaDate;

    @Builder
    public QnaRequestSavedto(String qnaName, LocalDate qnaDate, String qnaContent, String qnaTitle, String qnaPw) {
        this.qnaName = qnaName;
        this.qnaDate = qnaDate;
        this.qnaContent = qnaContent;
        this.qnaTitle = qnaTitle;
        this.qnaPw = qnaPw;
    }

    public Qna toEntity(){
        return Qna.builder()
                .qnaName(this.qnaName)
                .qnaDate(this.qnaDate)
                .qnaContent(this.qnaContent)
                .qnaTitle(this.qnaTitle)
                .qnaPw(this.qnaPw)
                .build();
    }
}
