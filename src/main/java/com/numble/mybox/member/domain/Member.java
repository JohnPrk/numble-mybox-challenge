package com.numble.mybox.member.domain;

import com.numble.mybox.member.service.dto.MemberResponse;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long usage;


    protected Member() {
        //no-op
    }

    public Member(String name) {
        this.name = name;
        this.usage = 0L;
    }

    public Member(Long id, String name, Long usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }
}
