package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.Boardservice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final Boardservice boardservice;

    @GetMapping("/save-form")
    public String saveBoard() {
        return "pages/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDto boardDto) {
        Long id = boardservice.save(boardDto);
        return "redirect:/board/" + id;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDto> boardDtoList = boardservice.findAll();
        model.addAttribute("boardList", boardDtoList);

        log.info("boardDtoList", boardDtoList);
        return "/pages/findAll";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        BoardDto boardDto = boardservice.findById(id);
        model.addAttribute("board", boardDto);
        return "/pages/detail";
    }

}
