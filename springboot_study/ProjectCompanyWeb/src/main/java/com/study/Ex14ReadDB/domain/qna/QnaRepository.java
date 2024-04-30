package com.study.Ex14ReadDB.domain.qna;

import com.study.Ex14ReadDB.domain.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QnaRepository extends JpaRepository<Qna, Long> {
    List<Qna> findAllByQnaIdx(Long qnaIdx);
    Optional<Qna> findNByQnaIdx(Long qnaIdx);
    List<Qna> findByQnaTitleContaining(String title);
    List<Qna> findByQnaContentContaining(String content);
    List<Qna> findByQnaNameContaining(String content);

}
