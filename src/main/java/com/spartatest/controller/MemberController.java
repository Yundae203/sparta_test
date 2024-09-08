package com.spartatest.controller;

import com.spartatest.dto.MemberRequest;
import com.spartatest.dto.MemberResponse;
import com.spartatest.entity.Member;
import com.spartatest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{id}")
    public MemberResponse findMember(@PathVariable Long id) {
        Member findMember = memberService.findById(id);
        return new MemberResponse(findMember.getId(), findMember.getName());
    }

    @PostMapping("/member")
    public String createMember(@RequestBody MemberRequest memberRequest) {
        memberService.save(memberRequest);
        return "success";
    }
}
