package com.study.Pr01Counter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController // @Controller + @ResponseBody
//@Controller
//@ResponseBody // 모든 메소드에 @ResponseBody를 붙이는 효과
@RequiredArgsConstructor
@RequestMapping("/api/v1")
class ApiController {
    @Autowired
    private final Counter counter;

    // URL : localhost:8080/api/v1/plus
    @PostMapping("/plus")
    public ResDto plus(){ // 요청했던 애들을 매개변수로 받아옴
        counter.setCount(counter.getCount()+1);
        ResDto resDto = new ResDto();
        resDto.setCount(counter.getCount());
        return resDto; // 클래스객체가 JSON응답(문자열)으로 전송된다.
    }
    @PostMapping("/minus")
    public ResDto minus(){ // 요청했던 애들을 매개변수로 받아옴
        counter.setCount(counter.getCount()-1);
        ResDto resDto = new ResDto();
        resDto.setCount(counter.getCount());
        return resDto; // 클래스객체가 JSON응답(문자열)으로 전송된다.
    }
}
