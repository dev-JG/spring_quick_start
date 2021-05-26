package com.spring.board.controller;

import com.spring.board.model.Board;
import com.spring.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public Board getBoard() {
        Board board = new Board();
        board.setBoardNo(1L);
        return boardService.getBoard(board);
    }
}