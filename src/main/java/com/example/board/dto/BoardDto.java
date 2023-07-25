package com.example.board.dto;

import com.example.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private Long id;

    private String title;

    private String writer;

    private String password;

    private String contents;

    private int hits;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public BoardDto(String title, String writer, String password, String contents) {
        this.title = title;
        this.writer = writer;
        this.password = password;
        this.contents = contents;
    }

    public static BoardDto from(BoardEntity boardEntity) {

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
