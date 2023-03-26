package com.numble.mybox.member.service.dto;

import com.numble.mybox.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponse {
    private final Long id;
    private final String name;
    private final Long usage;

    private MemberResponse(Long id, String name, Long usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }

    public static MemberResponse of(Member savedMember) {
        return new MemberResponse(savedMember.getId(), savedMember.getName(), savedMember.getUsage());
    }
}
