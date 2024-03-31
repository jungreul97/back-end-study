package com.study.Pr05Calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor // 필드를 초기화 하는 생성자를 자동으로 생성함
public class HtmlController {
    private final Calculator calculator;
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("num1",calculator.getNum1());
        model.addAttribute("num2",calculator.getNum2());
        model.addAttribute("result",calculator.getResult());
        return "index";
    }
}
