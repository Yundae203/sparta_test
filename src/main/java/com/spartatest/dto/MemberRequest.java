package com.spartatest.dto;

import com.spartatest.entity.Member;

public record MemberRequest(String name) {

    public Member toDomain() {
        return new Member(name);
    }
}
