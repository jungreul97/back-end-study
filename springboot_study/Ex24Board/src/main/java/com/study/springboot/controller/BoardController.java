package com.study.Ex14ReadDB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    // localhost : 8080/board/
    @GetMapping("/")
    public String main(){
        return "listForm"; // listForm.html
    }

}