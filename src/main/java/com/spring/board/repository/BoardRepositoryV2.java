package com.spring.board.repository;

import com.spring.board.model.Board;
import com.spring.board.model.BoardRowMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j
@Repository
public class BoardRepositoryV2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    private final String BOARD_GET = "select * from board where board_no=?";
    private final String BOARD_LIST_GET = "select * from board order by create_dt desc limit 10";
    private final String BOARD_LIST_INSERT = "insert into board(title, writer, content, create_dt) values(?, ?, ?, now())";
    private final String BOARD_LIST_INSERT2 = "insert into board(board_no, title, writer, content, create_dt) values(?,?, ?, ?, now())";

    public Board getBoard(Board board) {
        log.info("##### BoardRepositoryV2::getBoard");
        Object[] params = {board.getBoardNo()};
        return jdbcTemplate.queryForObject(BOARD_GET, params, new BoardRowMapper());
    }

    public List<Board> getBoardList() {
        log.info("##### BoardRepositoryV2::getBoardList");
        return jdbcTemplate.query(BOARD_LIST_GET, rowMapper);
    }

    public boolean insertBoard(Board board) {
        log.info("##### BoardRepositoryV2::insertBoard");
        Object[] params = {board.getTitle(), board.getWriter(), board.getContent()};
        return jdbcTemplate.update(BOARD_LIST_INSERT, params) > 0;
    }

    public boolean insertBoardV2(Board board) {
        log.info("##### BoardRepositoryV2::insertBoardV2");
        Object[] params = {5, board.getTitle(), board.getWriter(), board.getContent()};
        return jdbcTemplate.update(BOARD_LIST_INSERT2, params) > 0;
    }
}