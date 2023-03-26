package com.numble.mybox.member.domain;


import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    void deleteById(Long id);

    Optional<Member> findById(Long id);
}
