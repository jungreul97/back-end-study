package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.qna.Qna;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class QnaResponseDto {
    private Long qnaIdx;
    private String qnaName;
    private String qnaPw;
    private String qnaTitle;
    private String qnaContent;
    private LocalDate qnaDate;

    @Builder
    public QnaResponseDto(Qna entity) {
        this.qnaIdx = entity.getQnaIdx();
        this.qnaName = entity.getQnaName();
        this.qnaDate = entity.getQnaDate();
        this.qnaContent = entity.getQnaContent();
        this.qnaTitle = entity.getQnaTitle();
        this.qnaPw = entity.getQnaPw();
    }

}
