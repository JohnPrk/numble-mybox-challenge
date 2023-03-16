package com.numble.mybox.member.service.dto;

import lombok.Getter;

@Getter
public class MemberRequest {
    private String name;

    public MemberRequest() {
    }

    public MemberRequest(String name) {
        this.name = name;
    }
}
