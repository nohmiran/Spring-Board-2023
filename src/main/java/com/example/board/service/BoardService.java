package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardQueryDslRepository;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// DTO -> Entity (Entity Class)
// Entity -> DTO (DTO Class)

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardQueryDslRepository boardQueryDslRepository;

    public void save(BoardDto boardDto) {
        BoardEntity boardEntity = BoardEntity.from(boardDto);
        boardRepository.save(boardEntity);
    }

    public List<BoardDto> findByInvalidFalse() {
        List<BoardEntity> boardEntityList = boardRepository.findByInvalidFalse();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntityList) {
            boardDtoList.add(BoardDto.toBoardDto(boardEntity));
        }
        return boardDtoList;
    }

    public Page<BoardDto> paging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1;
        Page<BoardEntity> boardEntities = boardRepository.findByInvalidFalse(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id")));

        List<BoardDto> boardDtoList = boardEntities.getContent().stream()
                .map(BoardDto::toBoardDto)
                .collect(Collectors.toList());

        return new PageImpl<>(boardDtoList, pageable, boardEntities.getTotalElements());
    }

    @Transactional
    public void updateHits(Long id) {
        boardQueryDslRepository.updateHits(id);
    }

    @Transactional
    public BoardDto findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            BoardDto boardDto = BoardDto.toBoardDto(boardEntity);
            return boardDto;
        } else {
            return null;
        }
    }

    public void update(BoardDto boardDto) {
        BoardEntity boardEntity = boardRepository.findById(boardDto.getId()) // 해당 id로 기존 엔티티 조회
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다"));

        boardEntity.setTitle(boardDto.getTitle());
        boardEntity.setContents(boardDto.getContents());

        boardRepository.save(boardEntity);
    }

    public void updateInvalidTrue(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다"));
        boardEntity.setInvalid(true);
        boardRepository.save(boardEntity);
    }

}
