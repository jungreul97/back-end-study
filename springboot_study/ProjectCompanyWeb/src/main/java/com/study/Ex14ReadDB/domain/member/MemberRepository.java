package com.study.Ex14ReadDB.domain.member;

import com.study.Ex14ReadDB.domain.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
     Optional<Member> findByMemberId(String memberId);
     Optional<Member> findByMemberNameAndMemberEmail(String memberName, String memberEmail);
     Optional<Member> findByMemberNameAndMemberIdAndMemberEmail(String memberName, String memberId,String memberEmail);

//     List<Member> findByMemberIdContainingOrMemberNameContainingOrMemberEmailContaining(String all);
//     @Query("SELECT m FROM Member m WHERE m.memberId LIKE %?1% OR m.memberName LIKE %?1% OR m.memberEmail LIKE %?1%")
//     List<Member> findByKeywordContaining(String all);
     @Query("SELECT m FROM Member m WHERE LOWER(m.memberId) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(m.memberName) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(m.memberEmail) LIKE LOWER(CONCAT('%', ?1, '%'))")
     List<Member> findByKeywordContaining(String all);
     List<Member> findByMemberIdContaining(String id);
     List<Member> findByMemberNameContaining(String name);
     List<Member> findByMemberEmailContaining(String email);
}
