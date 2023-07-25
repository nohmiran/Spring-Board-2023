package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Boardservice {

    private final BoardRepository boardRepository;

    public Long save(BoardDto boardDto) {

        Long savedId = boardRepository.save(BoardEntity.from(boardDto)).getId();

        return savedId;
    }

    public List<BoardDto> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntityList) {
            boardDtoList.add(BoardDto.from(boardEntity));
        }
        return boardDtoList;
    }

    @Transactional
    public BoardDto findById(Long id) {

        // 조회수 처리
        // native sql : update   board_table
        //                 set   hits = hits + 1
        //                 where id = ?
        boardRepository.boardHits(id);
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
            return BoardDto.from(optionalBoardEntity.get());
        } else {
            return null;
        }
    }
}
