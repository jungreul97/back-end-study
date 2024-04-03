package com.study.Pr03VM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component // 기본생성자가 필요함.
@Data      // 기본생성자를 생성해주지는 않음
@NoArgsConstructor // 필드가 없는 생성자 생성
@AllArgsConstructor // 필드가 있는 생성자 생성
@Builder
public class Product {
    private String name; // 상품명
    private int price; // 가격
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate limit_date; // 유통기한


}
