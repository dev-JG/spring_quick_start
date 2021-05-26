package com.spring.board.service.impl;

import com.spring.board.model.Board;
import com.spring.board.repository.BoardRepository;
import com.spring.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board getBoard(Board board) {
        return boardRepository.getBoard(board);
    }
}