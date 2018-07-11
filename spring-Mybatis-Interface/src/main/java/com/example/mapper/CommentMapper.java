package com.example.mapper;

import com.example.dto.CommentDTO;
import com.example.common.RequestVO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by minah on 2016-09-30.
 */
public interface CommentMapper {

  public ArrayList<CommentDTO> findAll(RequestVO vo) throws SQLException;

  public Integer findAllCount(RequestVO vo) throws SQLException;

  public CommentDTO insertComment(CommentDTO comment) throws SQLException;

  public Integer updateComment(CommentDTO comment) throws SQLException;

  public Integer deleteComment(int cmtId) throws SQLException;

  public Integer deleteAllComment(int bbsId) throws SQLException;
}
