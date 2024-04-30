package com.study.Ex14ReadDB.domain.notice;

import com.study.Ex14ReadDB.domain.member.Member;
import com.study.Ex14ReadDB.domain.qna.Qna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice,Long>{
    List<Notice> findAllByNoticeIdx(Long noticeIdx);
    Optional<Notice> findNByNoticeIdx(Long noticeIdx);
    List<Notice> findByNoticeTitleContaining(String title);
    List<Notice> findByNoticeContentContaining(String content);
    List<Notice> findByNoticeMemberIdContaining(String content);
//    @Query("SELECT m FROM Notice m WHERE m.noticeMemberId LIKE %?1% OR m.noticeContent LIKE %?1% OR m.noticeTitle LIKE %?1%")
//    List<Notice> findByKeywordContaining(String all);
@Query("SELECT m FROM Notice m WHERE LOWER(m.noticeMemberId) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(m.noticeContent) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(m.noticeTitle) LIKE LOWER(CONCAT('%', ?1, '%'))")
List<Notice> findByKeywordContaining(String all);

}
