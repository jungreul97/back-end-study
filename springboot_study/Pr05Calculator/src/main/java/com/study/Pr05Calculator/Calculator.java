package com.study.Pr05Calculator;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Calculator {
    private int num1;
    private int num2;
    private double result;

    public Calculator() {
        this.num1 = 0;
        this.num2 = 0;
        this.result = 0;
    }

    public int add(int num1, int num2){
        return num1 + num2;
    }
    public int sub(int num1, int num2){
        return num1 - num2;
    }
    public int mul(int num1, int num2){
        return num1 * num2;
    }
    public double div(int num1, int num2){
        return (double)num1/num2;
    }
}
