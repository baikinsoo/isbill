package com.isbill.UpBoard.service;

import com.isbill.constant.Role;
import com.isbill.constant.Upgrade;
import com.isbill.Registre.infrastructure.Registre;
import com.isbill.UpBoard.infrastructure.UpBoard;
import com.isbill.Member.infrastructure.Member;
import com.isbill.UpBoard.domain.UpBoardFormDto;
import com.isbill.UpBoard.domain.UpgradeDto;
import com.isbill.Member.infrastructure.MemberRepository;
import com.isbill.Registre.infrastructure.RegistreRepository;
import com.isbill.UpBoard.infrastructure.UpBoardRepository;
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
    private final RegistreRepository registreRepository;

    public void editContent(UpBoard upBoard, UpBoardFormDto upBoardFormDto) {
        upBoard.setTitle(upBoardFormDto.getTitle());
        upBoard.setContent(upBoardFormDto.getContent());
        upBoardRepository.save(upBoard);
    }

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
        Registre registre = Registre.createRegistre(member);
        registreRepository.save(registre);
        memberRepository.save(member);
    }

    public void changeYes(Member member) {
        member.setUpgrade(Upgrade.YES);
        memberRepository.save(member);
    }

    public void delete(Long id) {
        upBoardRepository.deleteById(id);
    }
}
