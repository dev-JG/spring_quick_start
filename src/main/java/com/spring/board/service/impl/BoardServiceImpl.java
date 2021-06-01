package com.spring.board.service.impl;

import com.spring.board.model.Board;
import com.spring.board.repository.BoardRepository;
import com.spring.board.repository.BoardRepositoryV2;
import com.spring.board.service.BoardService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardRepositoryV2 boardRepositoryV2;

    @Override
    public Board getBoard(Board board) {
        return boardRepository.getBoard(board);
    }

    @Override
    public Board getBoardV2(Board board) {
        return boardRepositoryV2.getBoard(board);
    }

    @Override
    public List<Board> getBoardList() {
        return boardRepositoryV2.getBoardList();
    }

    @Override
    public boolean insertBoard(Board board) {
        boardRepositoryV2.insertBoard(board);
        return boardRepositoryV2.insertBoardV2(board);
    }
}