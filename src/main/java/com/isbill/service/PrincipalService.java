package com.isbill.service;

import com.isbill.domain.Member;
import com.isbill.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class PrincipalService {

    private final MemberRepository memberRepository;

    public Member findMember(Principal principal) {
        String name = principal.getName();
        return memberRepository.findByEmail(name);
    }
}
