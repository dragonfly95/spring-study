package com.example.mapper;

import com.example.dto.BoardDTO;
import com.example.common.RequestVO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by minah on 2016-09-30.
 */
public interface BoardMapper {

  public ArrayList<BoardDTO> findAll(RequestVO vo) throws SQLException;

  public Integer findAllCount(RequestVO vo) throws SQLException;

  public BoardDTO insertBoard(BoardDTO board) throws SQLException;

  public Integer updateBoard(BoardDTO board) throws SQLException;

  public Integer deleteBoard(int bbsId) throws SQLException;

}
