package com.spring.board.repository;

import com.spring.board.model.Board;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class BoardRepositoryV3 extends SqlSessionDaoSupport {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public Board getBoardByNo(Board board) {
        log.info("##### BoardRepositoryV3::getBoardByNo");
        return getSqlSession().selectOne("selectBoardByNo", board);
    }

    public List<Board> getBoardList() {
        log.info("##### BoardRepositoryV3::getBoardList");
        return getSqlSession().selectList("selectBoardList");
    }
}