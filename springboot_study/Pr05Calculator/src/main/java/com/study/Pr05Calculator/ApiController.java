package com.study.Pr05Calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController // 이거 왜 안해주냐!!!!
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ApiController {
    final Calculator calculator;
    @PostMapping("/add")
    public ResDto add(@RequestBody ReqDto reqDto){
        int num1 = Integer.parseInt(reqDto.getNum1());
        int num2 = Integer.parseInt(reqDto.getNum2());
        System.out.println(num1);
        System.out.println(num2);
        int result = calculator.add(num1,num2);
        ResDto resDto = new ResDto();
        resDto.setNum1(num1);
        resDto.setNum2(num2);
        resDto.setResult(result);
        return resDto;
    }
    @PostMapping("/sub")
    public ResDto sub(@RequestBody ReqDto reqDto){
        int num1 = Integer.parseInt(reqDto.getNum1());
        int num2 = Integer.parseInt(reqDto.getNum2());
        System.out.println(num1);
        System.out.println(num2);
        int result = calculator.sub(num1,num2);
        ResDto resDto = new ResDto();
        resDto.setNum1(num1);
        resDto.setNum2(num2);
        resDto.setResult(result);
        return resDto;
    }
    @PostMapping("/mul")
    public ResDto mul(@RequestBody ReqDto reqDto){
        int num1 = Integer.parseInt(reqDto.getNum1());
        int num2 = Integer.parseInt(reqDto.getNum2());
        System.out.println(num1);
        System.out.println(num2);
        int result = calculator.mul(num1,num2);
        ResDto resDto = new ResDto();
        resDto.setNum1(num1);
        resDto.setNum2(num2);
        resDto.setResult(result);
        return resDto;
    }
    @PostMapping("/div")
    public ResDto div(@RequestBody ReqDto reqDto){
        int num1 = Integer.parseInt(reqDto.getNum1());
        int num2 = Integer.parseInt(reqDto.getNum2());
        System.out.println(num1);
        System.out.println(num2);
        double result = calculator.div(num1,num2);
        ResDto resDto = new ResDto();
        resDto.setNum1(num1);
        resDto.setNum2(num2);
        resDto.setResult2(result);
        System.out.println(resDto.getResult2());
        return resDto;
    }

}
