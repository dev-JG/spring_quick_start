package com.spring.board.service;

import com.spring.board.model.Board;

import java.util.List;

public interface BoardService {
    Board getBoard(Board board);
    Board getBoardV2(Board board);
    Board getMyBatisBoard(Board board);
    List<Board> getBoardList();
    List<Board> getMyBatisBoardList();
    List<Board> getMyBatisBoardListV2();
    boolean insertBoard(Board board);
}