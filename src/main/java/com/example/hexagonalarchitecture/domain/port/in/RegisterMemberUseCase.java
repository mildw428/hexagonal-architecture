package com.example.hexagonalarchitecture.domain.port.in;

import com.example.hexagonalarchitecture.domain.model.Member;

public interface RegisterMemberUseCase {
    Member register(String name, String email);
}
