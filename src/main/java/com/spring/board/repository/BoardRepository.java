package com.spring.board.repository;

import com.spring.board.model.Board;
import com.spring.common.JdbcUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j
@Repository
public class BoardRepository {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private final String BOARD_GET = "select * from board where board_no=?";

    public Board getBoard(Board board) {
        log.info("##### BoardRepository::getBoard");
        Board result = null;

        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(BOARD_GET);
            preparedStatement.setLong(1, board.getBoardNo());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                result = new Board();
                result.setBoardNo(resultSet.getLong("board_no"));
                result.setTitle(resultSet.getString("title"));
                result.setWriter(resultSet.getString("writer"));
                result.setContent(resultSet.getString("content"));
                result.setCreateDt(resultSet.getString("create_dt"));
                result.setUpdateDt(resultSet.getString("update_dt"));
            }
        } catch (Exception e) {
            log.error("##### BoardRepository::getBoard error={}", e);
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, connection);
        }

        return result;
    }
}