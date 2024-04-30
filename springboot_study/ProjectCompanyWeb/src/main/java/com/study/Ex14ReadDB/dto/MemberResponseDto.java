package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.member.Member;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MemberResponseDto {
    private Long memberIdx;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private int memberEmailReceive;
    private int memberPwQuestion;
    private String memberPwAnswer;
    private String memberGender;
    private LocalDate memberBirthDate;
    private LocalDate memberJoinDate;

    public MemberResponseDto(Member entity) {
        this.memberJoinDate = entity.getMemberJoinDate();
        this.memberBirthDate = entity.getMemberBirthDate();
        this.memberGender = entity.getMemberGender();
        this.memberPwAnswer = entity.getMemberPwAnswer();
        this.memberPwQuestion = entity.getMemberPwQuestion();
        this.memberEmailReceive = entity.getMemberEmailReceive();
        this.memberEmail = entity.getMemberEmail();
        this.memberName = entity.getMemberName();
        this.memberPw = entity.getMemberPw();
        this.memberId = entity.getMemberId();
        this.memberIdx = entity.getMemberIdx();
    }
}
