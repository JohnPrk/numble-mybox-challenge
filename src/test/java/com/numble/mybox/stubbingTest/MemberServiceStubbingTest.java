package com.numble.mybox.stubbingTest;

import com.numble.mybox.member.domain.Member;
import com.numble.mybox.member.domain.MemberRepository;
import com.numble.mybox.member.service.MemberService;
import com.numble.mybox.member.service.dto.MemberResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceStubbingTest {

    private static final long ID = 1L;
    private static final String NAME = "사용자1";
    private static final long USAGE = 0L;


    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void saveMember() {
        //given
        given(memberRepository.save(any())).willReturn(new Member(ID, NAME, USAGE));

        //when
        MemberResponse memberResponse = memberService.join(any());

        //then
        assertThat(memberResponse).isNotNull();
        assertThat(memberResponse.getId()).isEqualTo(ID);
        assertThat(memberResponse.getName()).isEqualTo(NAME);
        assertThat(memberResponse.getUsage()).isEqualTo(USAGE);
    }
}
