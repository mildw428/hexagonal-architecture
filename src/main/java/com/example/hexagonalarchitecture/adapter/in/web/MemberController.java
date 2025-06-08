package com.example.hexagonalarchitecture.adapter.in.web;

import com.example.hexagonalarchitecture.domain.model.Member;
import com.example.hexagonalarchitecture.domain.port.in.RegisterMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @PostMapping
    public Member register(@RequestBody MemberRequest request) {
        return registerMemberUseCase.register(request.name(), request.email());
    }

    public record MemberRequest(String name, String email) {}
}
