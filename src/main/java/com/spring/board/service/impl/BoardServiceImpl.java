package com.spring.board.service.impl;

import com.spring.board.model.Board;
import com.spring.board.repository.BoardRepository;
import com.spring.board.repository.BoardRepositoryV2;
import com.spring.board.repository.MyBatisBoardRepository;
import com.spring.board.repository.MyBatisBoardRepositoryV2;
import com.spring.board.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardRepositoryV2 boardRepositoryV2;

    @Autowired
    private MyBatisBoardRepository myBatisBoardRepository;

    @Autowired
    private MyBatisBoardRepositoryV2 myBatisBoardRepositoryV2;

    @Override
    public Board getBoard(Board board) {
        log.info("##### BoardService::getBoard");
        return boardRepository.getBoard(board);
    }

    @Override
    public Board getBoardV2(Board board) {
        log.info("##### BoardService::getBoardV2");
        return boardRepositoryV2.getBoard(board);
    }

    @Override
    public Board getMyBatisBoard(Board board) {
        log.info("##### BoardService::getMyBatisBoard");
        return myBatisBoardRepository.getBoardByNo(board);
    }

    @Override
    public List<Board> getBoardList() {
        log.info("##### BoardService::getBoardList");
        return boardRepositoryV2.getBoardList();
    }

    @Override
    public List<Board> getMyBatisBoardList() {
        log.info("##### BoardService::getMyBatisBoardList");
        return myBatisBoardRepository.getBoardList();
    }

    @Override
    public List<Board> getMyBatisBoardListV2() {
        log.info("##### BoardService::getMyBatisBoardList");
        return myBatisBoardRepositoryV2.getBoardList();
    }

    @Override
    public boolean insertBoard(Board board) {
        log.info("##### BoardService::insertBoard");
        boardRepositoryV2.insertBoard(board);
        return boardRepositoryV2.insertBoardV2(board);
    }
}