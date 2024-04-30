package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private int memberEmailReceive;
    private int memberPwQuestion;
    private String memberPwAnswer;
    private String memberGender;
    private LocalDate memberBirthDate;

    @Builder
    public MemberSaveRequestDto(String memberId, String memberPw, String memberName, String memberEmail, int memberEmailReceive, int memberPwQuestion, String memberPwAnswer, String memberGender, LocalDate memberBirthDate) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberEmailReceive = memberEmailReceive;
        this.memberPwQuestion = memberPwQuestion;
        this.memberPwAnswer = memberPwAnswer;
        this.memberGender = memberGender;
        this.memberBirthDate = memberBirthDate;

    }

    public Member toEntity(){
        return Member.builder().memberId(this.memberId).memberPw(this.memberPw).memberName(this.memberName).memberEmail(this.memberEmail).memberEmailReceive(this.memberEmailReceive).memberPwQuestion(this.memberPwQuestion).memberPwAnswer(this.memberPwAnswer).memberGender(this.memberGender).memberBirthDate(this.memberBirthDate).memberJoinDate(LocalDate.now()).build();
    }
}
