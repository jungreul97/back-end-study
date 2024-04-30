package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.domain.member.Member;
import com.study.Ex14ReadDB.dto.MemberResponseDto;
import com.study.Ex14ReadDB.dto.MemberSaveRequestDto;
import com.study.Ex14ReadDB.dto.Reqdto;
import com.study.Ex14ReadDB.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/loginAction")
    @ResponseBody
    public String loginAction(HttpServletRequest request, @RequestParam String loginID, @RequestParam String loginPW){
        System.out.println("loginID : " + loginID);
        System.out.println("loginPW : " + loginPW);

        MemberResponseDto dto = memberService.findByMemberId(loginID);
        if( dto != null  && dto.getMemberId().equals(loginID)){
            if(dto.getMemberPw().equals(loginPW)){
                request.getSession().setAttribute("user",loginID);
                return "<script>alert('로그인되었습니다'); location.href='/';</script>";
            }else{
                return "<script>alert('비밀번호가 다릅니다.'); history.back();</script>";
            }
        }else{
            return "<script>alert('아이디가 존재하지 않습니다.'); history.back();</script>";
        }
    }

    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@ModelAttribute MemberSaveRequestDto dto) {
        Long newIdx = memberService.save(dto);

        boolean isFound = memberService.existsById(newIdx);
        if (isFound) {
            return "<script>alert('회원가입이 완료되었습니다. 로그인하세요.'); location.href='/member/login';</script>";
        } else {
            return "<script>alert('회원가입 실패'); history.back();</script>";
        }
    }

    @PostMapping("/findIdAction")
    public String findIdAction(@RequestParam String memberName, @RequestParam String memberEmail, Model model){
        System.out.println(memberName);
        System.out.println(memberEmail);
        String memberId = memberService.findByMemberNameAndMemberEmail(memberName, memberEmail);
        model.addAttribute("memberId", memberId);
        return "member/findIdResult";
    }

    @PostMapping("/findPwAction")
    public String findPwAction(@RequestParam String memberName, @RequestParam String memberEmail, @RequestParam String memberId, Model model) {
        // MemberService를 사용하여 이름과 이메일로 멤버 아이디 찾기
        String memberPw = memberService.findByMemberNameAndMemberIdAndMemberEmail(memberName, memberId, memberEmail);

        // 모델에 멤버 아이디 추가. 아이디가 없는 경우 null이 추가됩니다.
        model.addAttribute("memberPw", memberPw);

        // 아이디 찾기 결과를 보여줄 뷰 이름 반환
        return "member/findPwResult";
    }


}
