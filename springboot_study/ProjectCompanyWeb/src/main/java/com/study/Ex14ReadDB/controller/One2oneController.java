package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.NoticeResponseDto;
import com.study.Ex14ReadDB.dto.One2oneSaveRequestDto;
import com.study.Ex14ReadDB.service.One2oneService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class One2oneController {
    private final One2oneService one2oneService;
    @GetMapping("/customer01")
    @ResponseBody
    public String customerLoginCheck(HttpServletRequest request){
        HttpSession session = request.getSession(false); // 현재 세션 가져오기, 없으면 null 반환
        if (session == null || session.getAttribute("user") == null) {
            return "<script>alert('로그인해주세요'); location.href='/member/login';</script>";
        }
        return "<script>location.href='/customer/customer01check';</script>";
    }

    @GetMapping("/customer01check")
    public String community01(Model model){
        return "/customer/customer01";
    }


    @PostMapping("/writeOne2oneAction")
    @ResponseBody
    public String writeOne2oneAction(@ModelAttribute One2oneSaveRequestDto dto){
        Long newIdx = one2oneService.save(dto);

        boolean isFound = one2oneService.existsById(newIdx);
        if (isFound) {
            return "<script>alert('1대1문의가 완료되었습니다.'); location.href='/';</script>";
        } else {
            return "<script>alert('1대1문의 실패!'); history.back();</script>";
        }

    }

}
