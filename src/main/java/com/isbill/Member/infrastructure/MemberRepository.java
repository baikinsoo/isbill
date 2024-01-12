package com.isbill.Member.infrastructure;

import com.isbill.Member.infrastructure.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
