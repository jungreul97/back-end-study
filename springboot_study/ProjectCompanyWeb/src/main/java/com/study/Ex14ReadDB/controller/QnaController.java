package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.NoticeResponseDto;
import com.study.Ex14ReadDB.dto.QnaResponseDto;
import com.study.Ex14ReadDB.service.QnaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class QnaController {
    private final QnaService qnaService;

    @GetMapping("/customer02")
    @ResponseBody
    public String customer02LoginCheck(HttpServletRequest request){
        HttpSession session = request.getSession(false); // 현재 세션 가져오기, 없으면 null 반환
        if (session == null || session.getAttribute("user") == null) {
            return "<script>alert('로그인해주세요'); location.href='/member/login';</script>";
        }
        return "<script>location.href='/customer/customer02check';</script>";
    }


    @GetMapping("/customer02check")
    public String customer02(Model model){
        List<QnaResponseDto> list = qnaService.findAll();
        model.addAttribute("list", list);
        return "/customer/customer02";
    }

    @GetMapping("/customer03")
    @ResponseBody
    public String customer03LoginCheck(HttpServletRequest request){
        HttpSession session = request.getSession(false); // 현재 세션 가져오기, 없으면 null 반환
        if (session == null || session.getAttribute("user") == null) {
            return "<script>alert('로그인해주세요'); location.href='/member/login';</script>";
        }
        return "<script>location.href='/customer/customer03check';</script>";
    }

    @GetMapping("/customer03check")
    public String customer03(){
        return "/customer/customer03";
    }


    @GetMapping("/customer02_3")
    public String showPasswordForm(@RequestParam("qna_idx") Long qnaIdx, Model model) {
        model.addAttribute("qnaIdx", qnaIdx);
        return "/customer/customer02_3";
    }

    @PostMapping("/checkPwAction")
    public String checkPwAction(@RequestParam String qnaPw, @RequestParam Long qnaIdx, RedirectAttributes redirectAttributes){
        System.out.println(qnaPw);
        System.out.println(qnaIdx);
        QnaResponseDto dto = qnaService.findByQnaIdx(qnaIdx);

        if (dto.getQnaPw().equals(qnaPw)) {
            // 비밀번호가 맞으면 다음 페이지로 넘어갑니다.
            redirectAttributes.addAttribute("qnaIdx",qnaIdx);
            return "redirect:/customer/customer02_4";
        } else {
            // 비밀번호가 틀렸을 경우, qnaIdx를 리다이렉트 속성에 추가합니다.
            redirectAttributes.addAttribute("qna_idx", qnaIdx);
            return "redirect:/customer/customer02_3";
        }
    }

    @GetMapping("/customer02_4")
    public String customer02_4(@RequestParam Long qnaIdx, Model model){
        QnaResponseDto dto = qnaService.findByQnaIdx(qnaIdx);
        model.addAttribute("qna",dto);
        return "/customer/customer02_4";
    }

    @GetMapping("/searchQnaAction")
    public String searchQnas(@RequestParam("searchType") String searchType,
                                @RequestParam("keyword") String keyword,
                                Model model) {
        List<QnaResponseDto> list = qnaService.searchQna(searchType,keyword);
        model.addAttribute("list", list);
        return "/customer/customer02"; // 검색 결과를 보여줄 뷰의 이름
    }




}
