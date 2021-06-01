package com.spring;

import com.spring.board.model.Board;
import com.spring.board.repository.BoardRepositoryV2;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-bean.xml",
        "classpath:/spring/applicationContext-database.xml",
        "classpath:/spring/applicationContext-transaction.xml",
        "classpath:/spring/applicationContext-aop.xml",
        "classpath:mvc-config.xml"})
public class BoardServiceTest {

    @Autowired
    private BoardRepositoryV2 boardRepositoryV2;

    @Test
    public void 보드_조회_테스트() {
      log.info("##### 보드_조회_테스트");
    }

    @Test
    public void 게시글_조회_테스트() {
        Board board = new Board();
        board.setBoardNo(1L);
        Board result = boardRepositoryV2.getBoard(board);
        log.info("##### 게시글_조회_테스트");
        log.info(result);
    }

    @Test
    public void 게시글_리스트_조회_테스트() {
        log.info("##### 게시글_리스트_조회_테스트");
        log.info(boardRepositoryV2.getBoardList());
    }
}
