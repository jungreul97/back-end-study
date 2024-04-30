package com.study.Ex14ReadDB.dto;

import com.study.Ex14ReadDB.domain.one2one.One2one;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class One2oneSaveRequestDto {
    private String one2oneName;
    private String one2onePhone;
    private String one2oneEmail;
    private String one2oneAddress;
    private String one2oneTitle;
    private String one2oneContent;
    private LocalDate one2oneDate;

    @Builder
    public One2oneSaveRequestDto(LocalDate one2oneDate, String one2oneContent, String one2oneTitle, String one2oneAddress, String one2oneEmail, String one2onePhone, String one2oneName) {
        this.one2oneDate = one2oneDate;
        this.one2oneContent = one2oneContent;
        this.one2oneTitle = one2oneTitle;
        this.one2oneAddress = one2oneAddress;
        this.one2oneEmail = one2oneEmail;
        this.one2onePhone = one2onePhone;
        this.one2oneName = one2oneName;
    }
    public One2one toEntity(){
        return One2one.builder()
                .one2oneName(this.one2oneName)
                .one2onePhone(this.one2onePhone)
                .one2oneEmail(this.one2oneEmail)
                .one2oneTitle(this.one2oneTitle)
                .one2oneContent(this.one2oneContent)
                .one2oneAddress(this.one2oneAddress)
                .one2oneDate(LocalDate.now())
                .build();
    }
}
