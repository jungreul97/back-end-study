package com.study.Ex14ReadDB.service;

import com.study.Ex14ReadDB.domain.notice.Notice;
import com.study.Ex14ReadDB.domain.qna.Qna;
import com.study.Ex14ReadDB.domain.qna.QnaRepository;
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
public class QnaService {
    private final QnaRepository qnaRepository;

    @Transactional(readOnly = true)
    public List<QnaResponseDto> findAll(){ //전체 목록 조회
        //정렬기능 추가
        Sort sort = Sort.by(Sort.Direction.ASC, "qnaDate", "qnaIdx");
        List<Qna> list = qnaRepository.findAll( sort );

        //List<Board>를 List<BoardResponseDto>로 변환 : stream()메소드 사용
        return list.stream().map(QnaResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public QnaResponseDto findByQnaIdx(Long qnaIdx){
        Optional<Qna> entity = Optional.ofNullable(qnaRepository.findNByQnaIdx(qnaIdx)
                .orElse(null));
        return entity.isEmpty() ? null : new QnaResponseDto(entity.get());
    }
    @Transactional
    public List<QnaResponseDto> searchQna(String searchType, String keyword) {
        List<Qna>  list;
        if ("title".equals(searchType)) {
            list = qnaRepository.findByQnaTitleContaining(keyword);
            return list.stream().map(QnaResponseDto::new).collect(Collectors.toList());
        } else if ("content".equals(searchType)) {
            list = qnaRepository.findByQnaContentContaining(keyword);
            return list.stream().map(QnaResponseDto::new).collect(Collectors.toList());
        } else if ("name".equals(searchType)){
            list = qnaRepository.findByQnaNameContaining(keyword);
            return list.stream().map(QnaResponseDto::new).collect(Collectors.toList());
        } else {
            return List.of(); // 잘못된 검색 타입인 경우 빈 리스트 반환
        }
    }

}
