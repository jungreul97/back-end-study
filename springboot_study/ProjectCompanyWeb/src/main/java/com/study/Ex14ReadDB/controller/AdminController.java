package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.domain.notice.Notice;
import com.study.Ex14ReadDB.dto.MemberResponseDto;
import com.study.Ex14ReadDB.dto.NoticeResponseDto;
import com.study.Ex14ReadDB.dto.NoticeSaveRequestDto;
import com.study.Ex14ReadDB.dto.QnaResponseDto;
import com.study.Ex14ReadDB.service.MemberService;
import com.study.Ex14ReadDB.service.NoticeService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final MemberService memberService;
    private final NoticeService noticeService;

    @GetMapping("/admin")
    public String adminLogin(){
        return "/admin/admin_login";
    }

    @GetMapping("/admin/admin_member")
    public String admin_member(@RequestParam(defaultValue = "id_asc") String order, @RequestParam(defaultValue = "5") String dataSize, Model model){
        List<MemberResponseDto> list = memberService.findAll(order, dataSize);
        model.addAttribute("list", list);
        return "/admin/admin_member";
    }

    @GetMapping("/admin/searchMemberAction")
    public String searchNotices(@RequestParam("searchType") String searchType,
                                @RequestParam("keyword") String keyword,
                                Model model) {
        List<MemberResponseDto> list = memberService.searchMember(searchType,keyword);
        model.addAttribute("list", list);
        model.addAttribute("searchType", searchType);
        model.addAttribute("keyword", keyword);
        return "/admin/admin_member"; // 검색 결과를 보여줄 뷰의 이름
    }

    @GetMapping("/admin/searchAdminNoticeAction")
    public String searchAdminNotices(@RequestParam("searchType") String searchType,
                                @RequestParam("keyword") String keyword,
                                Model model) {
        List<NoticeResponseDto> list = noticeService.searchAdminNotice(searchType,keyword);
        model.addAttribute("list", list);
        model.addAttribute("searchType", searchType);
        model.addAttribute("keyword", keyword);
        return "/admin/admin_notice"; // 검색 결과를 보여줄 뷰의 이름
    }

    @GetMapping("/admin/admin_notice")
    public String admin_notice(@RequestParam(defaultValue = "member_id_asc") String order, @RequestParam(defaultValue = "5") String dataSize, Model model){
        List<NoticeResponseDto> list = noticeService.findAll(order, dataSize);
        model.addAttribute("list", list);
        return "/admin/admin_notice";
    }

    @GetMapping("/admin/admin_member/search")
    @ResponseBody
    public List<MemberResponseDto> searchWithOrder(@RequestParam(defaultValue = "id_asc") String sortOrder, @RequestParam(defaultValue = "5") String dataSize) {
        System.out.println(sortOrder);
        return memberService.findAll(sortOrder,dataSize);
    }
    @GetMapping("/admin/admin_notice/search")
    @ResponseBody
    public List<NoticeResponseDto> searchWithOrder1(@RequestParam(defaultValue = "id_asc") String sortOrder, @RequestParam(defaultValue = "5") String dataSize) {
        System.out.println(sortOrder);
        return noticeService.findAll(sortOrder,dataSize);
    }

    @GetMapping("/admin/admin_notice_write")
    public String admin_notice_write(){
        return "/admin/admin_notice_write";
    }
//    @PostMapping("/adminLoginAction")
//    @ResponseBody
//    public String adminLoginAction(@RequestParam String member_id, @RequestParam String member_pw){
//        if (member_id.equals("admin") && member_pw.equals("1234")){
//
//            return "<script>alert('관리자님 안녕하세요'); location.href='/admin/admin_member';</script>";
//        }else{
//            return "<script>alert('회원가입 실패'); history.back();</script>";
//        }
//    }
        @PostMapping("/adminLoginAction")
        public String adminLoginAction(@RequestParam String member_id, @RequestParam String member_pw,HttpServletResponse response){
            if (member_id.equals("admin") && member_pw.equals("1234")){
                // 쿠키에 사용자 ID 저장
                Cookie cookie = new Cookie("member_id", member_id);
                cookie.setPath("/"); // 모든 경로에서 접근 가능하도록 설정
                cookie.setMaxAge(60 * 60); // 쿠키 유효 시간 설정 (예: 1시간)
                response.addCookie(cookie);
                return "redirect:/admin/admin_member";
            }else{
                return "/admin/admin_login";
            }
        }


    @PostMapping("/noticeWriteAction")
    @ResponseBody
    public String noticeWriteAction(@ModelAttribute NoticeSaveRequestDto dto,HttpServletRequest request){
        String memberId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("member_id".equals(cookie.getName())) {
                    memberId = cookie.getValue();
                    break;
                }
            }
        }
        System.out.println("******************"+memberId);
        dto.setNoticeMemberId(memberId);
        Long newIdx = noticeService.save(dto);
        return "<script>alert('공지사항이 등록되었습니다.'); location.href='/admin/admin_notice';</script>";
    }

    @GetMapping("/admin/admin_notice_view")
    public String admin_notice_view(@RequestParam("notice_idx") Long noticeIdx, Model model){
        NoticeResponseDto dto = noticeService.findByNoticeIdx(noticeIdx);
        model.addAttribute("notice",dto);
        return "/admin/admin_notice_view";
    }

    @PostMapping("/noticeUpdateAction")
    @ResponseBody
    public String updateAction(@ModelAttribute NoticeSaveRequestDto dto,
                               @RequestParam("noticeIdx") Long noticeIdx){
        Notice entity = noticeService.update(noticeIdx, dto);
        if( entity.getNoticeIdx() == noticeIdx ) {
            return "<script>alert('공지사항 수정 성공'); location.href='/admin/admin_notice';</script>";
        }else{
            return "<script>alert('공지사항 수정 실패'); history.back();</script>";
        }
    }
}