package com.numble.mybox.member.presentation;

import com.numble.mybox.member.service.MemberService;
import com.numble.mybox.member.service.dto.MemberRequest;
import com.numble.mybox.member.service.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberResponse> join(@RequestBody MemberRequest memberRequest) {
        MemberResponse memberResponse = memberService.join(memberRequest.getName());
        return ResponseEntity.created(URI.create("/members/" + memberResponse.getId())).body(memberResponse);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
