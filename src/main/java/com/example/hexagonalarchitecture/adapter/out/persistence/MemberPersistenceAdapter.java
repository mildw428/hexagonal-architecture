package com.example.hexagonalarchitecture.adapter.out.persistence;

import com.example.hexagonalarchitecture.domain.model.Member;
import com.example.hexagonalarchitecture.domain.port.out.SaveMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements SaveMemberPort {

    private final MemberRepository repository;

    @Override
    public Member save(Member member) {
        MemberJpaEntity entity = new MemberJpaEntity();
        entity.setName(member.getName());
        entity.setEmail(member.getEmail());
        MemberJpaEntity saved = repository.save(entity);
        return new Member(saved.getId(), saved.getName(), saved.getEmail());
    }
}
