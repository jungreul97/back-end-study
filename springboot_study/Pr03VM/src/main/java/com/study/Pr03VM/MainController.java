package com.study.Pr03VM;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.css.Counter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    public static List<Product> productlist = new ArrayList<>();
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("list", productlist);
        model.addAttribute("count", productlist.size());
        return "productList";
    }
    @GetMapping("/addProductForm")
    public String addProductForm(){
        return "addProductForm";
    }
    // Form의 INput을 받는 방법
    //1. @RequestParam 단일 매개변수
    //2. @ModelAttribute 객체 매핑(바인딩)
    @PostMapping("/addProduct")
//    @ResponseBody // 문자열로 내보낼거기 때문에
    // null 을 허용한다. null일 때 기본값을 ""로 찍혀버린다.
    public String addProduct(@RequestParam(required = false, defaultValue = "") String inputName, @RequestParam int inputPrice, @RequestParam LocalDate inputLimitDate){ // html파일에 id에 저장해놓은 값 변수 그대로 들고왕
        System.out.println(inputName);
        System.out.println(inputPrice);
        System.out.println(inputLimitDate);
        Product product = Product.builder().name(inputName).price(inputPrice).limit_date(inputLimitDate).build();
        productlist.add(product);
        System.out.println("size : "+productlist.size());
//        return "<script>alert('상품이 추가되었습니다.'); location.href='/';</script>";
        return "redirect:/";
        // main으로 다시 보내줌 대문초기화면으로 보내줌
        // 전달하면, 웹브라우저는 받자마자 이경로로 다시 요청함.
    }
    // editProductForm?index=0
    @GetMapping("/editProductForm")
    public String editProductForm(@RequestParam("index") int index,Model model){
        Product product = productlist.get(index);
        model.addAttribute("product", product);
        model.addAttribute("index",index); // index도 같이 정보를 전달해줘야된다 editform에서 받으려면
        return "editProductForm";
    }
    @PostMapping("/editProduct")
    @ResponseBody
    public String editProduct(@RequestParam int index, @RequestParam(required = false, defaultValue = "") String inputName, @RequestParam int inputPrice, @RequestParam LocalDate inputLimitDate){
        System.out.println(inputName);
        System.out.println(inputPrice);
        System.out.println(inputLimitDate);
        // Product product = list.get(index);
        // product.setName(inputName);
        // product.setPrice(inputPrice);
        // product.setLimit_date(inputLimitDate);
        Product product = Product.builder().name(inputName).price(inputPrice).limit_date(inputLimitDate).build();
        productlist.set(index,product);
        System.out.println("index : "+index);
        System.out.println("size : "+productlist.size());
        return "<script>alert('수정되었습니다.'); location.href='/';</script>";

    }
    // deleteProduct?index=0
    @GetMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(@RequestParam("index") int index){
        productlist.remove(index);
        System.out.println("index : "+index);
        System.out.println("size : "+productlist.size());
        return "<script>alert('상품이 삭제되었습니다.'); location.href='/';</script>";
    }
}
