package com.numble.mybox.member.infra;

import com.numble.mybox.member.domain.Member;
import com.numble.mybox.member.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Member save(Member member);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Member> findById(Long id);
}
