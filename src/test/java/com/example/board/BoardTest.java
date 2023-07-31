package com.example.board;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardService boardservice;

//    public BoardDto newBoard(int i) {
//        BoardDto boardDto = new BoardDto("title" + i, "writer" + i, "password" + i, "contents" + i);
//        return boardDto;
//    }

//    @Test
//    @Transactional
//    @Rollback(value = false)
//    public void saveTest() {
//
//        IntStream.rangeClosed(1,20).forEach(i->{
//            boardservice.save(newBoard(i));
//        });
//
//    }
}
