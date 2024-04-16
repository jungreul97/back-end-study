package com.study.springboot.dto;

import com.study.springboot.domain.reply.Reply;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor // 매개변수 생성자
@NoArgsConstructor // 기본생성자, 순서 중요함
public class ReplySaveRequestDto {
    private String replyContent;
    private String replyName;
    private Long replyBoardIdx; // 외래키 - 게시글 인덱스

//    @Builder
//    public ReplySaveRequestDto(Long replyBoardIdx, String replyName, String replyContent) {
//        this.replyBoardIdx = replyBoardIdx;
//        this.replyName = replyName;
//        this.replyContent = replyContent;
//    }

    // Entity객체로 바꾸기
    public Reply toEntity(){
        return Reply.builder().replyContent(this.replyContent).replyName(this.replyName).replyBoardIdx(this.replyBoardIdx).build();
    }

}
