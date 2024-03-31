package com.study.Pr01Counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private Counter counter;

    @GetMapping("/")
    public String main(){
        return "counter";
    }

    @GetMapping("/plus")
    public String incrementCounter(Model model) {
        counter.setCount(counter.getCount() + 1);
        model.addAttribute("count", counter.getCount());
        return "redirect:/";// 다시 모델에 넣어주고 렌더링함 기본페이지에서
    }

    @GetMapping("/minus")
    public String decrementCounter(Model model) {
        counter.setCount(counter.getCount() - 1);
        model.addAttribute("count", counter.getCount());
        return "counter";
    }
}
