package com.example.service.impl;

import com.example.domain.Board;
import com.example.domain.QBoard;
import com.example.repository.BoardRepository;
import com.example.service.BoardService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by minah on 2016-10-02.
 */
@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardRepository boardRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Board> findAll() throws SQLException {
    return boardRepository.findAll();
  }

  @Override
  public List<Board> findByBbsTitle(String bbsTitle) throws SQLException {
    return boardRepository.findByBbsTitle(bbsTitle);
  }

  @Override
  public Board findByBbsId(Integer bbsId) {
    return boardRepository.findByBbsId(bbsId);
  }

  @Override
  public Page<Board> getBoard(int bbsId, Pageable pageable) {

    JPAQuery query = new JPAQuery(entityManager);
    QBoard board = QBoard.board;

    query.select(board).from(board);
    query.where(board.bbsId.eq(bbsId));
    query.orderBy(board.bbsTitle.asc());
    query.limit(pageable.getPageSize()).offset(pageable.getOffset());

    List<Board> result = query.fetch();

    return new PageImpl<Board>(result, pageable, result.size());
  }

  @Override
  @Transactional
  public Board insertBoard(Board board) {
    return boardRepository.save(board);
  }

  @Override
  @Transactional
  public Board updateBoard(Board board) {
    return boardRepository.save(board);
  }

  @Override
  @Transactional
  public void deleteBoard(Integer bbsId) {
    boardRepository.delete(bbsId);
  }
}
