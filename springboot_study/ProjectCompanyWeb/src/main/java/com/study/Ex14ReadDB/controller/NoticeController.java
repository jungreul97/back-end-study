package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.NoticeResponseDto;
import com.study.Ex14ReadDB.service.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/community01")
    @ResponseBody
    public String communityLoginCheck(HttpServletRequest request){
        HttpSession session = request.getSession(false); // 현재 세션 가져오기, 없으면 null 반환
        if (session == null || session.getAttribute("user") == null) {
            return "<script>alert('로그인해주세요'); location.href='/member/login';</script>";
        }
        return "<script>location.href='/community/community01check';</script>";
    }

    @GetMapping("/community01check")
    public String community01(Model model){
        List<NoticeResponseDto> list = noticeService.findAll();
        model.addAttribute("list", list);
        return "/community/community01";
    }

    @GetMapping("/community01_1")
    public String noticeDetail(@RequestParam("notice_idx") Long noticeIdx, Model model) {
        NoticeResponseDto notice = noticeService.findById(noticeIdx);
        model.addAttribute("notice", notice);
        return "/community/community01_1"; // 공지사항 상세 페이지의 뷰 이름
    }
    @GetMapping("/searchNoticeAction")
    public String searchNotices(@RequestParam("searchType") String searchType,
                                @RequestParam("keyword") String keyword,
                                Model model) {
        List<NoticeResponseDto> list = noticeService.searchNotice(searchType,keyword);
        model.addAttribute("list", list);
        return "/community/community01"; // 검색 결과를 보여줄 뷰의 이름
    }

}
