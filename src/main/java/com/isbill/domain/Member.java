package com.isbill.domain;

import com.isbill.constant.Role;
import com.isbill.dto.MemberFormDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    //기본적으로 Enum은 순서가 저장되는데, enum의 순서가 바뀔 경우 문제가 발생할 수 있으므로 String으로 비교하기 위해 EnumType를 STRING으로 한다.
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registre_id")
    private Registre registre;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);
        return member;
    }
}
