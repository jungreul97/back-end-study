package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.MemberResponseDto;
import com.study.Ex14ReadDB.dto.Reqdto;
import com.study.Ex14ReadDB.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final MemberService memberService;
    @PostMapping("/member/checkDuplicateID")
    public ResponseEntity<Map<String, Boolean>> checkMemberId(@RequestBody Reqdto reqdto) {
        MemberResponseDto dto = memberService.findByMemberId(reqdto.getMemberId());
        System.out.println(dto);
        Map<String, Boolean> response = new HashMap<>();
        if(dto != null){
            response.put("isDuplicate", true);
        } else {
            response.put("isDuplicate", false);
        }

        return ResponseEntity.ok(response);
    }
}
