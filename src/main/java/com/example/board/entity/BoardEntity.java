package com.example.board.entity;

import com.example.board.dto.BoardDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "demo_board")
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 20)
    private String writer;

    @Column(length = 20)
    private String password;

    @Column(length = 500)
    private String contents;

    @Column
    private int hits;

    public static BoardEntity from(BoardDto boardDto) {

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setTitle(boardDto.getTitle());
        boardEntity.setWriter(boardDto.getWriter());
        boardEntity.setPassword(boardDto.getPassword());
        boardEntity.setContents(boardDto.getContents());
        boardEntity.setHits(0);

        return boardEntity;
    }
}
