package com.study.springboot.dto;

import com.study.springboot.domain.reply.Reply;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class ReplyResponseDto {
    private Long replyIdx;
    private String replyName; //작성자
    private String replyContent; // 댓글 내용
    private LocalDateTime replyDate; // 댓글생성일시, 수정일시
    private Long replyBoardIdx; //외래키

    public ReplyResponseDto(Reply entity) {
        this.replyDate = entity.getReplyDate();
        this.replyContent = entity.getReplyContent();
        this.replyName = entity.getReplyName();
        this.replyIdx = entity.getReplyIdx();
        this.replyBoardIdx = entity.getReplyIdx();
    }
}
