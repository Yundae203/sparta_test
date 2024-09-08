package com.spartatest.service;

import com.spartatest.entity.Member;
import com.spartatest.dto.MemberRequest;
import com.spartatest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberRequest dto) {
        memberRepository.save(dto.toDomain());
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Member not found with id : " + id));
    }

}
