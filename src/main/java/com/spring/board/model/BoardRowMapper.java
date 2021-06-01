package com.spring.board.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<Board> {

    @Override
    public Board mapRow(ResultSet resultSet, int i) throws SQLException {
        Board board = new Board();
        board.setBoardNo(resultSet.getLong("board_no"));
        board.setTitle(resultSet.getString("title"));
        board.setWriter(resultSet.getString("writer"));
        board.setContent(resultSet.getString("content"));
        board.setCreateDt(resultSet.getString("create_dt"));
        board.setUpdateDt(resultSet.getString("update_dt"));

        return board;
    }
}
