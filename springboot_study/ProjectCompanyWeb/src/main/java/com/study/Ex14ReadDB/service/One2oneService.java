package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.member.Member;
import com.study.Ex14ReadDB.domain.one2one.One2one;
import com.study.Ex14ReadDB.domain.one2one.One2oneRepository;
import com.study.Ex14ReadDB.dto.MemberSaveRequestDto;
import com.study.Ex14ReadDB.dto.One2oneSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class One2oneService {
    private final One2oneRepository one2oneRepository;

    @Transactional
    public Long save(final One2oneSaveRequestDto dto){
        One2one entity = one2oneRepository.save( dto.toEntity() );
        return entity.getOne2oneIdx();
    }
    @Transactional(readOnly = true)
    public boolean existsById(Long ono2oneIdx){
        boolean isFound = one2oneRepository.existsById(ono2oneIdx);
        return isFound;
    }

}
