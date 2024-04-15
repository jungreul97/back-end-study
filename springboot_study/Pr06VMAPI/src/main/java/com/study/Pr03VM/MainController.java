package com.study.Pr03VM;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.css.Counter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    final ProductRepository productRepository;
    @GetMapping("/")
    public String main(){
        return "productList";
    }

    @GetMapping("/addProductForm")
    public String addProductForm(){
        return "addProductForm";
    }

    @GetMapping("/editProductForm")
    public String editProductForm(@RequestParam int index, Model model){
        model.addAttribute("index",index);
        Product product = productRepository.productlist.get(index);
        model.addAttribute("product",product);
        return "editProductForm";
    }
}
