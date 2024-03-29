package com.isbill.FreeComment.infrastructure;

import com.isbill.FreeBoard.infrastructure.FreeBoard;
import com.isbill.Member.infrastructure.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class FreeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "freeBoard_id")
    private FreeBoard freeBoard;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
