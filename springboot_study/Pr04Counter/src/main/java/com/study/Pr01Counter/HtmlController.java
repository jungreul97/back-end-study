package com.study.Pr01Counter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class HtmlController {
    private final Counter counter;
    @GetMapping("/")
    public String main(Model model){
        System.out.println("counter:"+counter);
        model.addAttribute("count", counter.getCount());
        return "index";
    }
}
