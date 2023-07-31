package com.example.board.dto;

import com.example.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

// DTO(Data Transfer Object), VO, Bean,    Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class BoardDto {

    private Long id;

    private String title;

    private String writer;

    private String password;

    private String contents;

    private int hits;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public BoardDto(Long id, String title, String writer, String password, String contents) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.password = password;
        this.contents = contents;
    }

    public static BoardDto toBoardDto(BoardEntity boardEntity) {

        BoardDto boardDto = new BoardDto();
        boardDto.setId(boardEntity.getId());
        boardDto.setTitle(boardEntity.getTitle());
        boardDto.setWriter(boardEntity.getWriter());
        boardDto.setPassword(boardEntity.getPassword());
        boardDto.setContents(boardEntity.getContents());
        boardDto.setHits(boardEntity.getHits());
        boardDto.setCreatedDate(boardEntity.getCreatedDate());
        boardDto.setUpdatedDate(boardEntity.getUpdatedDate());

        return boardDto;
    }

}
