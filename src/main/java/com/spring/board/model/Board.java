package com.spring.board.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Board {
    private long boardNo;
    private String title;
    private String writer;
    private String content;
    private String createDt;
    private String updateDt;

    @Override
    public String toString() {
        return "Board{" +
                "boardNo=" + boardNo +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", createDt='" + createDt + '\'' +
                ", updateDt='" + updateDt + '\'' +
                '}';
    }
}