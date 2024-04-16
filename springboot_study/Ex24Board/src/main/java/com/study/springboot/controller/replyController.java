package com.study.springboot.controller;

import com.study.springboot.dto.ReplySaveRequestDto;
import com.study.springboot.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/reply")
public class replyController {
    final private ReplyService replyService;
    // "/writeReplyAction"

    @PostMapping("/writeReplyAction")
    @ResponseBody
    public String writeReplyAction(@ModelAttribute ReplySaveRequestDto dto, @RequestParam("replyBoardIdx") Long replyBoardIdx){ // 변수가 다를때는 생략해도 됨
        Long newReplyIdx = replyService.save(dto);
        boolean isFound = replyService.existsBy(newReplyIdx);
        if(isFound){
            return "<script>alert('댓글쓰기 성공'); location.href='/';</script>";
        }else{
            return "<script>alert('댓글쓰기 실패'); history.back();</script>";
        }
    }

    @GetMapping("deleteAction")
    @ResponseBody
    public String deleteAction(@RequestParam Long replyIdx,@RequestParam Long boardIdx){
        replyService.delete(replyIdx);
        return "<script>alert('댓글지우기 성공'); location.href='/board/contentForm?boardIdx="+boardIdx+"';</script>";
    }

}
