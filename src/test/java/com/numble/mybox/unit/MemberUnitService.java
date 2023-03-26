package com.numble.mybox.unit;

import com.numble.mybox.member.service.MemberService;
import com.numble.mybox.member.service.dto.MemberResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberUnitService {

    private static final String NAME = "사용자1";

    @Autowired
    private MemberService memberService;

    @Test
    void deleteMember() {
        //given
        MemberResponse savedMember = memberService.join(NAME);

        //when
        Long id = savedMember.getId();
        memberService.delete(id);

        //then
        Assertions.assertThat(memberService.findById(id)).isEqualTo(Optional.empty());
    }
}
