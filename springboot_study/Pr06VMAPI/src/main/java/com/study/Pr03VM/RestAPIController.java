package com.study.Pr03VM;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestAPIController {
    final ProductRepository productRepository;

    public RestAPIController(ProductRepository productRepository) {
        this.productRepository = productRepository;

        Product product1 = Product.builder().name("소고기버거").price(9000).limit_date(LocalDate.parse("2024-02-01")).build();
        Product product2 = Product.builder().name("토마토버거").price(6000).limit_date(LocalDate.parse("2024-01-01")).build();
        Product product3 = Product.builder().name("배추버거").price(3000).limit_date(LocalDate.parse("2024-04-01")).build();

        productRepository.productlist.add(product1);
        productRepository.productlist.add(product2);
        productRepository.productlist.add(product3);
    }
    @GetMapping("/products")
    public List<Product> products(){
        return productRepository.productlist;
    }

    @PostMapping("/product")
    public ResDto addProduct(@RequestBody AddProductDto dto){
        System.out.println(dto.getInputName());

        Product product = Product.builder().name(dto.getInputName()).price(dto.getInputPrice()).limit_date(dto.getInputLimitDate()).build();
        productRepository.productlist.add(product);

        ResDto resDto = ResDto.builder().status("ok").message("추가되었습니다").count(1).build();

        return resDto;
    }

    // RequestBody에 태워보낸 객체에서 정보를 가져옴
    @PutMapping("/product")
    public ResDto editProduct(@RequestBody EditProductDto dto){
        int index = dto.getProductIndex();
        Product product = Product.builder().name(dto.getInputName()).price(dto.getInputPrice()).limit_date(dto.getInputLimitDate()).build();
        productRepository.productlist.set(index,product);

        ResDto resDto = ResDto.builder()
                .status("ok").message("수정되었습니다.")
                .count(1).build();

        return resDto;

    }

    //http://localhost:8080/deleteProduct?index=0
    @DeleteMapping("/deleteProduct")
    public ResDto deleteProduct(@RequestParam int index){
        productRepository.productlist.remove( index );

        ResDto dto = ResDto.builder()
                .status("ok").message("삭제되었습니다")
                .count(1).build();

        return dto;
    }

}
