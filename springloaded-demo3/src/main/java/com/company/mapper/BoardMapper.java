package com.company.mapper;


import com.company.demo3.BoardVO;

import java.util.List;

public interface BoardMapper {
    public int boardCount();

    public List<BoardVO> getlist();

    public BoardVO doDetail(int id);

    public int doWrite(BoardVO boardVO);

    public int deleteDo(int id);

    public int upDate(BoardVO boardVO);
}
