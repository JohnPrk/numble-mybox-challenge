package com.numble.mybox.member.service.dto;

import lombok.Getter;

@Getter
public class MemberResponse {
    private final Long id;
    private final String name;
    private final Long usage;

    public MemberResponse(Long id, String name, Long usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }
}
