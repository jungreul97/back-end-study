package com.study.Ex02.SpringDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller : HTTP 요청을 처리하는 컨트롤 클래스에 붙임.
// GET/POST/PUT/DELETE 요청 등을 처리한다.

@Controller
public class MainController {
    // @GetMapping : HTTP Get요청을 처리하는 함수에 붙인다.
    // 내부적으로 메소드는 Servlet으로 동작한다.
    // @ResponseBody : 응답을 문자열(JSON)로 응답한다는 의미.
    // 요청 URL : localhost:8090/
    @GetMapping("/")
    @ResponseBody
    public String main(){ // 서블릿으로 동작한다.
        return "스프링부트 웹애플리케이션 첫 응답!";
    }
    // 요청 URL : localhost:8090/test
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "테스트입니다.";
    }
    // 스프링 빈을 주입받는 방법
    // 1. 필드 주입
    // @Autowired : 스프링 빈을 주입해주는 어노테이션. 스프링컨테이너에서 new 해서 알아서 넣어준다.
    @Autowired
    private Member member1; // 빈 주입
    @Autowired // 한번에 하나씩 해야된다.
    private Member member2; // 빈 주입

    @GetMapping("/field")
    @ResponseBody
    public String field(){
        System.out.println("member1 : "+member1);
        System.out.println("member2 : "+member2);
        return "field() 호출됨 - " + member1.getName();
    }

    // 2. 수정자(setter) 주입
    private Member member3;
    @Autowired
    public void setMember(Member member){ // 여기로 바로 투입됨
        this.member3 = member;
    }
    @GetMapping("/setter")
    @ResponseBody
    public String setter(){
        return "setter() 호출됨 : "+member3.getName();
    }

    // 3. 생성자(constructor) 주입 - 추천
    // 1. final 키워드 사용가능(객체 재할당 방지)
    // 2. 생성자로서 미리 주입을 받을 수 있다. null safety를 제공.
    private final Member member4;
    @Autowired
    public MainController(Member member){
        // 레거시 자바 프로그램
        // 직접 주입
        Member member5 = new Member();
        this.member4 = member;
    }
    @GetMapping("/constructor")
    @ResponseBody
    public String constructor(){
        return "constructor() 호출 : "+member4.getName();
    }
}
