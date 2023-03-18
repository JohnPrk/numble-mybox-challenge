package com.numble.mybox.member.domain;


public interface MemberRepository {

    Member save(Member member);

    void deleteById(Long id);
}
