package com.study.Ex03.Autowired;

import org.springframework.stereotype.Component;

// 미지정 시 Bean의 이름 : "bCCard"
@Component("cardBC") // Bean의 이름을 직접 지정할 수 있다.
public class BCCard implements ICard {
    @Override
    public void buy(String itemName) {
        System.out.println("BCCard"+itemName);
    }
}