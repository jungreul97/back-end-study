package com.study.Ex09RestAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){
        // 첫화면 진입시 데이터 초기화한다.
        Member member = new Member("홍길동","1234","abc@dot.com", LocalDate.now());
        // 이렇게도 선언이 가능하다. 하나를 빼먹게 되도 생성이 가능하다.
        Member member1 = Member.builder()
                        .username("hong")
                        .password("1234")
                        .email("erw@dot.com")
                        .joindate(LocalDate.now()).build();
        ApiController.memberList.add(member);
        ApiController.memberList.add(member1);
        return "login"; // login.html로 응답
    }
}
