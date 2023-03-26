package com.numble.mybox.member.service;

import com.numble.mybox.member.domain.Member;
import com.numble.mybox.member.domain.MemberRepository;
import com.numble.mybox.member.service.dto.MemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse join(String name) {
        Member savedMember = memberRepository.save(new Member(name));
        return MemberResponse.of(savedMember);
    }

    @Transactional
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}
