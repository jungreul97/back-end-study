package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.member.Member;
import com.study.Ex14ReadDB.domain.member.MemberRepository;
import com.study.Ex14ReadDB.domain.notice.Notice;
import com.study.Ex14ReadDB.domain.notice.NoticeRepository;
import com.study.Ex14ReadDB.domain.qna.Qna;
import com.study.Ex14ReadDB.dto.MemberResponseDto;
import com.study.Ex14ReadDB.dto.MemberSaveRequestDto;
import com.study.Ex14ReadDB.dto.NoticeResponseDto;
import com.study.Ex14ReadDB.dto.QnaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll(String order, String dataSize){ //정렬 옵션 파라미터 추가
        Sort sort;
        System.out.println("@@@@@@@@@@@@22" + order);
        switch (order) {
            case "id_asc":
                sort = Sort.by(Sort.Direction.ASC, "memberId");
                break;
            case "id_desc":
                sort = Sort.by(Sort.Direction.DESC, "memberId");
                break;
            case "join_date_asc":
                sort = Sort.by(Sort.Direction.ASC, "memberJoinDate");
                break;
            case "join_date_desc":
                sort = Sort.by(Sort.Direction.DESC, "memberJoinDate");
                break;
            default: // 기본값 설정
                sort = Sort.by(Sort.Direction.ASC, "memberId");
        }
        List<Member> list = memberRepository.findAll(sort);
        if (dataSize.equals("all")){
            return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
        }else{
            int endIndex = Math.min(Integer.parseInt(dataSize),list.size());
            List<Member> subList = list.subList(0,endIndex);
            return subList.stream().map(MemberResponseDto::new).collect(Collectors.toList());
        }

    }

    @Transactional
    public Long save(final MemberSaveRequestDto dto){
        Member entity = memberRepository.save( dto.toEntity() );
        return entity.getMemberIdx();
    }
    @Transactional(readOnly = true)
    public boolean existsById(Long memberIdx){
        boolean isFound = memberRepository.existsById( memberIdx );
        return isFound;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findByMemberId(String memberId){
        Optional<Member> entity = Optional.ofNullable(memberRepository.findByMemberId(memberId)
                .orElse(null));
        return entity.isEmpty() ? null : new MemberResponseDto(entity.get());
    }

    @Transactional(readOnly = true)
    public String findByMemberNameAndMemberEmail(String memberName, String memberEmail){
        Optional<Member> entity = Optional.ofNullable(memberRepository.findByMemberNameAndMemberEmail(memberName,memberEmail)
                .orElse(null));
        return entity.isEmpty() ? null : entity.get().getMemberId();
    }
    @Transactional(readOnly = true)
    public String findByMemberNameAndMemberIdAndMemberEmail(String memberName, String memberId, String memberEmail){
        Optional<Member> entity = Optional.ofNullable(memberRepository.findByMemberNameAndMemberIdAndMemberEmail(memberName,memberId, memberEmail)
                .orElse(null));
        return entity.isEmpty() ? null : entity.get().getMemberPw();
    }
    @Transactional
    public List<MemberResponseDto> searchMember(String searchType, String keyword) {
        List<Member>  list;
        if ("all".equals(searchType)) {
            list = memberRepository.findByKeywordContaining(keyword);
            return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
        } else if ("id".equals(searchType)) {
            list = memberRepository.findByMemberIdContaining(keyword);
            return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
        } else if ("name".equals(searchType)){
            list = memberRepository.findByMemberNameContaining(keyword);
            return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
        } else if("email".equals(searchType)) {
            list = memberRepository.findByMemberEmailContaining(keyword);
            return list.stream().map(MemberResponseDto::new).collect(Collectors.toList());
        } else {
            return List.of(); // 잘못된 검색 타입인 경우 빈 리스트 반환
        }
    }





}
