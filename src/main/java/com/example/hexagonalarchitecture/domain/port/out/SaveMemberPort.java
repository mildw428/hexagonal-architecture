package com.example.hexagonalarchitecture.domain.port.out;

import com.example.hexagonalarchitecture.domain.model.Member;
import org.springframework.stereotype.Component;

public interface SaveMemberPort {
    Member save(Member member);
}
