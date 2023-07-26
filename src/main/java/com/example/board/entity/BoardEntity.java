package com.example.board.entity;

import com.example.board.dto.BoardDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

// DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name = "demo_board")
public class BoardEntity extends InvalidEntity{
    @Id // PK지정
    @Comment("PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "board_id")
    private Long id;

    @Comment("글 제목")
    @Column(length = 50, nullable = false) // 크기 50, not null
    private String title;

    @Comment("글 작성자")
    @Column(length = 20, nullable = false)
    private String writer;

    @Comment("글 수정/삭제 비밀번호")
    @Column(length = 20)
    private String password;

    @Comment("글 내용")
    @Column(length = 500)
    private String contents;

    @Comment("글 조회수")
    @Column
    private int hits;

    public static BoardEntity toSaveEntity(BoardDto boardDto) {

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setTitle(boardDto.getTitle());
        boardEntity.setWriter(boardDto.getWriter());
        boardEntity.setPassword(boardDto.getPassword());
        boardEntity.setContents(boardDto.getContents());
        boardEntity.setHits(0);

        return boardEntity;
    }
    public static BoardEntity toUpdateEntity(BoardDto boardDto) {

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setId(boardDto.getId());
        boardEntity.setTitle(boardDto.getTitle());
        boardEntity.setWriter(boardDto.getWriter());
        boardEntity.setPassword(boardDto.getPassword());
        boardEntity.setContents(boardDto.getContents());
        boardEntity.setHits(boardDto.getHits());

        return boardEntity;
    }
}
