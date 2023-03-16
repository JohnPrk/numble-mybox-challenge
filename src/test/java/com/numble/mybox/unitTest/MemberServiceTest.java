package com.numble.mybox.unitTest;

import com.numble.mybox.member.service.MemberService;
import com.numble.mybox.member.service.dto.MemberResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


public class MemberServiceTest {


    @InjectMocks
    private final MemberService memberService;

    public MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    void test() {
        MemberResponse 사용자1 = memberService.join("사용자1");

        Assertions.assertThat(사용자1).isNotNull();
    }
}
