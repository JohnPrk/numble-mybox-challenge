package com.numble.mybox.member.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberRequest {
    private String name;

    protected MemberRequest() {
        // no-op
    }
}
