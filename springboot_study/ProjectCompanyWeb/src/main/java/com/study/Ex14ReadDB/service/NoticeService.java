package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.member.Member;
import com.study.Ex14ReadDB.domain.notice.Notice;
import com.study.Ex14ReadDB.domain.notice.NoticeRepository;
import com.study.Ex14ReadDB.domain.qna.Qna;
import com.study.Ex14ReadDB.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findAll(){ //전체 목록 조회
        //정렬기능 추가
        Sort sort = Sort.by(Sort.Direction.ASC, "noticeDate", "noticeIdx");
        List<Notice> list = noticeRepository.findAll( sort );

        //List<Board>를 List<BoardResponseDto>로 변환 : stream()메소드 사용
        return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<NoticeResponseDto> searchNotice(String searchType, String keyword) {
        if ("title".equals(searchType)) {
            List<Notice> list = noticeRepository.findByNoticeTitleContaining(keyword);
            return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
        } else if ("content".equals(searchType)) {
            List<Notice> list = noticeRepository.findByNoticeContentContaining(keyword);
            return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
        } else {
            return List.of(); // 잘못된 검색 타입인 경우 빈 리스트 반환
        }
    }

    @Transactional
    public List<NoticeResponseDto> searchAdminNotice(String searchType, String keyword) {
        List<Notice> list;
        if ("all".equals(searchType)) {
            list = noticeRepository.findByKeywordContaining(keyword);
            return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
        } else if ("member_id".equals(searchType)) {
            list = noticeRepository.findByNoticeMemberIdContaining(keyword);
            return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
        } else if ("title".equals(searchType)) {
            list = noticeRepository.findByNoticeTitleContaining(keyword);
            return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
        } else if ("content".equals(searchType)) {
            list = noticeRepository.findByNoticeContentContaining(keyword);
            return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
        } else {
            return List.of();
        }
    }

    @Transactional(readOnly = true)
    public NoticeResponseDto findById(Long noticeIdx){
        Notice entity = noticeRepository.findById( noticeIdx )
                .orElseThrow( () -> new IllegalArgumentException(
                        "없는 글인덱스입니다.boardIdx:"+noticeIdx));
        return new NoticeResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findAll(String order, String dataSize){ //정렬 옵션 파라미터 추가
        Sort sort;
        System.out.println("@@@@@@@@@@@@22" + order);
        switch (order) {
            case "member_id_asc":
                sort = Sort.by(Sort.Direction.ASC, "noticeMemberId");
                break;
            case "member_id_desc":
                sort = Sort.by(Sort.Direction.DESC, "noticeMemberId");
                break;
            case "date_asc":
                sort = Sort.by(Sort.Direction.ASC, "noticeDate");
                break;
            case "date_desc":
                sort = Sort.by(Sort.Direction.DESC, "noticeDate");
                break;
            default: // 기본값 설정
                sort = Sort.by(Sort.Direction.ASC, "noticeMemberId");
        }
        List<Notice> list = noticeRepository.findAll(sort);
        if (dataSize.equals("all")){
            return list.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
        }else{
            int endIndex = Math.min(Integer.parseInt(dataSize),list.size());
            List<Notice> subList = list.subList(0,endIndex);
            return subList.stream().map(NoticeResponseDto::new).collect(Collectors.toList());
        }

    }
    @Transactional
    public Long save(final NoticeSaveRequestDto dto){
        Notice entity = noticeRepository.save( dto.toEntity() );
        return entity.getNoticeIdx();
    }
    @Transactional(readOnly = true)
    public NoticeResponseDto findByNoticeIdx(Long noticeIdx){
        Optional<Notice> entity = Optional.ofNullable(noticeRepository.findNByNoticeIdx(noticeIdx)
                .orElse(null));
        return entity.isEmpty() ? null : new NoticeResponseDto(entity.get());
    }
    @Transactional
    public Notice update(final Long noticeIdx, final NoticeSaveRequestDto dto){
        Notice entity = noticeRepository.findById(noticeIdx)
                .orElseThrow( () -> new IllegalArgumentException(
                        "없는 글인덱스입니다.boardIdx:"+noticeIdx));
        System.out.println(">>>>>>>>>>>>>>>"+dto.getNoticeContent());
        entity.update(dto.getNoticeContent(),dto.getNoticeTitle(),dto.getNoticeMemberId());
        return entity;
    }

}
