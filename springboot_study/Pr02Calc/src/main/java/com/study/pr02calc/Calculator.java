package com.study.pr02calc;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Data
public class Calculator {
    private int num1;
    private int num2;
    private int result;
}
