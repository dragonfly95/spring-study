package com.company.demo3;

import com.company.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {


    @Autowired
    public BoardMapper boardMapper ;

    /**
     * 게시판 전체 게시물 숫자입니다.
     * @return
     */
    public int boardCount() {
        int boardCount = boardMapper.boardCount();
        return boardCount;
    }

    /**
     * 게시판에서 목록을 가져옵니다.
     * @return
     */
    public List<BoardVO> getlist() {
        List<BoardVO> getlist = boardMapper.getlist();
        return getlist;
    }

    public BoardVO doDetail(int id) {
        BoardVO boardVO = boardMapper.doDetail(id);
        return  boardVO;
    }

    public int doWrite(BoardVO boardVO) {
        return boardMapper.doWrite(boardVO);
    }

    public int deleteDo(int id) {
        return boardMapper.deleteDo(id) ;
    }

    public int upDate(BoardVO boardVO) {
        return boardMapper.upDate(boardVO);

    }
}
