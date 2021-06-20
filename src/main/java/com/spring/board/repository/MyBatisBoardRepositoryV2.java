package com.spring.board.repository;

import com.spring.board.model.Board;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class MyBatisBoardRepositoryV2 {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<Board> getBoardList() {
        log.info("##### BoardRepositoryV3::getBoardList");
        return sqlSessionTemplate.selectList("selectBoardList");
    }
}