package com.example.service;

import com.example.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by minah on 2016-09-30.
 */
@Service
public interface BoardService {

  public List<Board> findAll() throws SQLException;
  public List<Board> findByBbsTitle(String bbsTitle) throws SQLException;
  public Board findByBbsId(Integer bbsId);

  public Page<Board> getBoard(int bbsId, Pageable pageable);

  public Board insertBoard(Board board);
  public Board updateBoard(Board board);
  public void deleteBoard(Integer bbsId);

}
