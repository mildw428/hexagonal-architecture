package com.example.hexagonalarchitecture.domain.service;

import com.example.hexagonalarchitecture.domain.model.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberDomainService {
    public Member createMember(String name, String email) {
        // 간단한 유효성 검증 예시
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");
        return new Member(null, name, email);
    }
}
