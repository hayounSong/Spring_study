package Spring_study.Spring_study.repository;

import Spring_study.Spring_study.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findBtId(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
