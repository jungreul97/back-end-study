package com.study.pr02calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    Calculator calculator;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("num1", calculator.getNum1());
        model.addAttribute("num2", calculator.getNum2());
        model.addAttribute("result", calculator.getResult());
        return "index";
    }

    @GetMapping("/add")
    public String add(@RequestParam int num1, @RequestParam int num2, Model model) {
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        calculator.setResult(num1+num2);
        model.addAttribute("num1", calculator.getNum1());
        model.addAttribute("num2", calculator.getNum2());
        model.addAttribute("result", calculator.getResult());
        return "index";
    }

    @GetMapping("/sub")
    public String sub(@RequestParam int num1, @RequestParam int num2, Model model) {
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        calculator.setResult(num1-num2);
        model.addAttribute("num1", calculator.getNum1());
        model.addAttribute("num2", calculator.getNum2());
        model.addAttribute("result", calculator.getResult());
        return "index";
    }

    @GetMapping("/mul")
    public String mul(@RequestParam int num1, @RequestParam int num2, Model model) {
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        calculator.setResult(num1*num2);
        model.addAttribute("num1", calculator.getNum1());
        model.addAttribute("num2", calculator.getNum2());
        model.addAttribute("result", calculator.getResult());
        return "index";
    }

    @GetMapping("/div")
    public String div(@RequestParam int num1, @RequestParam int num2, Model model) {
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        calculator.setResult(num1/num2);
        model.addAttribute("num1", calculator.getNum1());
        model.addAttribute("num2", calculator.getNum2());
        model.addAttribute("result", calculator.getResult());
        return "index";
    }
    @GetMapping("/del")
    public String del(Model model) {
        calculator.setNum1(0);
        calculator.setNum2(0);
        calculator.setResult(0);

        model.addAttribute("num1", calculator.getNum1());
        model.addAttribute("num2", calculator.getNum2());
        model.addAttribute("result", calculator.getResult());
        return "index";
    }

}
