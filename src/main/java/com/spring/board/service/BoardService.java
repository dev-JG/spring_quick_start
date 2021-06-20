package com.spring.board.service;

import com.spring.board.model.Board;

import java.util.List;

public interface BoardService {
    Board getBoard(Board board);
    Board getBoardV2(Board board);
    Board getBoardV3(Board board);
    List<Board> getBoardList();
    List<Board> getBoardListV3();
    boolean insertBoard(Board board);
}