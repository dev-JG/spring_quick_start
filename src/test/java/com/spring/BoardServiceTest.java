package com.spring;

import com.spring.board.model.Board;
import com.spring.board.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-bean.xml",
        "classpath:/spring/applicationContext-database.xml",
        "classpath:/spring/applicationContext-transaction.xml",
        "classpath:/spring/applicationContext-aop.xml",
        "classpath:mvc-config.xml",
        "classpath:mybatis-config.xml"})
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void 보드_조회_테스트() {
      log.info("##### 보드_조회_테스트");
    }

    @Test
    public void 게시글_조회_테스트() {
        log.info("##### 게시글_조회_테스트");
        Board board = new Board();
        board.setBoardNo(1L);
        Board result = boardService.getBoard(board);
        log.info(result);
    }

    @Test
    public void 게시글_리스트_조회_테스트() {
        log.info("##### 게시글_리스트_조회_테스트");
        log.info(boardService.getBoardList());
    }

    @Test
    public void 게시글_입력_테스트() {
        log.info("##### 게시글_입력_테스트");
        Board board = new Board();
        board.setTitle("테스트용 제목입니다.");
        board.setWriter("작성자입니다.");
        board.setContent("게시글 내용입니다.");
        log.info(boardService.insertBoard(board));
    }

    @Test
    public void 마이바티스_게시글_한개_가져오기_테스트() {
        log.info("##### 마이바티스_게시글_가져오기_테스트");
        Board board = new Board();
        board.setBoardNo(1L);
        log.info(boardService.getBoardV3(board));
    }

    @Test
    public void 마이바티스_게시글_리스트로_가져오기_테스트() {
        log.info("##### 마이바티스_게시글_리스트로_가져오기_테스트");
        log.info(boardService.getBoardListV3());
    }
}
