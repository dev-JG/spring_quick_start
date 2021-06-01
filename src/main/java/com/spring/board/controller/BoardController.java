package com.spring.board.controller;

import com.spring.board.model.Board;
import com.spring.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public Board getBoard() {
        Board board = new Board();
        board.setBoardNo(1L);
        return boardService.getBoardV2(board);
    }

    @GetMapping("/board/list")
    public List<Board> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/board/add")
    public boolean insertBoard() {
        Board board = new Board();
        board.setTitle("테스트용 제목입니다.");
        board.setWriter("작성자입니다.");
        board.setContent("게시글 내용입니다.");
        return boardService.insertBoard(board);
    }
}