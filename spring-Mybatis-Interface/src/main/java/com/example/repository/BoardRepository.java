package com.example.repository;

import com.example.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by minah on 2016-10-02.
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
  public List<Board> findByBbsTitle(String bbsTitle);
  public Board findByBbsId(Integer bbsId);
}
