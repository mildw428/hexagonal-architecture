package com.example.hexagonalarchitecture.application.service;

import com.example.hexagonalarchitecture.domain.model.Member;
import com.example.hexagonalarchitecture.domain.port.in.RegisterMemberUseCase;
import com.example.hexagonalarchitecture.domain.port.out.SaveMemberPort;
import com.example.hexagonalarchitecture.domain.service.MemberDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterMemberService implements RegisterMemberUseCase {

    private final SaveMemberPort saveMemberPort;
    private final MemberDomainService domainService;


    @Override
    @Transactional
    public Member register(String name, String email) {
        Member member = domainService.createMember(name, email);
        return saveMemberPort.save(member);
    }
}
