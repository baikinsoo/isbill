package com.isbill.service;

import com.isbill.constant.Role;
import com.isbill.constant.Upgrade;
import com.isbill.domain.UpBoard;
import com.isbill.domain.Member;
import com.isbill.dto.UpBoardFormDto;
import com.isbill.dto.UpgradeDto;
import com.isbill.repository.MemberRepository;
import com.isbill.repository.UpBoardRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Transactional
public class UpBoardService {

    private final UpBoardRepository upBoardRepository;
    private final MemberRepository memberRepository;

    public void saveContent(UpBoardFormDto upBoardFormDto, Member member) {

        UpBoard upBoard = new UpBoard();
        upBoard.setTitle(upBoardFormDto.getTitle());
        upBoard.setContent(upBoardFormDto.getContent());
        upBoard.setMember(member);

        upBoardRepository.save(upBoard);
    }

    public List<UpBoard> findAll() {
        return upBoardRepository.findAll();
    }

    public UpBoard findOne(Long id) {
        return upBoardRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public void upgrade(UpgradeDto upgradeDto) {
        Long memberId = upgradeDto.getMemberId();
        Member member = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
        member.setRole(Role.USER);
        memberRepository.save(member);
    }

    public void changeYes(Member member) {
        member.setUpgrade(Upgrade.YES);
        memberRepository.save(member);
    }
}
