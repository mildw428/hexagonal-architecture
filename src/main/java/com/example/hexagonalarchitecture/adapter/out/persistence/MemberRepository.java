package com.example.hexagonalarchitecture.adapter.out.persistence;

import com.example.hexagonalarchitecture.domain.model.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberJpaEntity, Long> {
}
