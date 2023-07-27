package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
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
    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm() {
        return "pages/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDto boardDto) {
        boardService.save(boardDto);
        return "redirect:/board/";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        // DB에서 전체 게시글 데이터를 가져와서 보여줌.
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "pages/list";
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        boardService.updateHits(id); // 해당 게시글 조회수 + 1
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "pages/detail";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDto);
        return "pages/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDto boardDto, Model model) {
        boardService.update(boardDto);
        BoardDto updatedBoardDto = boardService.findById(boardDto.getId());
        model.addAttribute("board", updatedBoardDto);
        return "/pages/detail";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute BoardDto boardDto) {
        boardService.updateInvalidTrue(boardDto.getId());
        return "redirect:/board/";
    }
}
