CREATE TABLE `board` (
  `board_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '번호',
  `title` varchar(200) NOT NULL COMMENT '제목',
  `writer` varchar(20) NOT NULL COMMENT '작성자',
  `content` varchar(2000) NOT NULL COMMENT '내용',
  `create_dt` datetime DEFAULT NULL COMMENT '작성일',
  `update_dt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
  PRIMARY KEY (`board_no`),
  KEY `idx_board_no` (`board_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판정보';

INSERT INTO board(title, writer, content, create_dt) VALUES ('테스트게시글입니다1.', '테스트유저1', '테스트내용입니다1.', now());
INSERT INTO board(title, writer, content, create_dt) VALUES ('테스트게시글입니다2.', '테스트유저2', '테스트내용입니다2.', now());

CREATE TABLE `user` (
   `user_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '번호',
   `id` varchar(20) NOT NULL COMMENT '아이디',
   `pw` varchar(20) NOT NULL COMMENT '비밀번호',
   `name` varchar(20) NOT NULL COMMENT '이름',
   `role` varchar(10) NOT NULL COMMENT '권한',
   `create_dt` datetime DEFAULT NULL COMMENT '가입일',
   PRIMARY KEY (`user_no`),
   KEY `idx_user_no` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='계정정보';

INSERT INTO user(id, pw, name, role, create_dt) VALUES ('user1', 'userpw1', '테스트유저1', 'user', now());
INSERT INTO user(id, pw, name, role, create_dt) VALUES ('user2', 'userpw2', '테스트유저2', 'user', now());