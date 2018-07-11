package com.example.controller;

import com.example.domain.Board;
import com.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by minah on 2016-10-01.
 */
@RestController
@RequestMapping(value = "api")
public class BoardController {

  @Autowired
  BoardService boardService;

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<Board> all() throws SQLException {
    return boardService.findAll();
  }


  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @ResponseBody
  public Page<Board> list(@RequestParam int bbsId, Pageable pageable) throws SQLException {
    return boardService.getBoard(bbsId, pageable);
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ResponseBody
  public Board create(@RequestBody Board board) {
    System.out.print("board.getBbsTitle() :: " + board.getBbsTitle());
    return boardService.insertBoard(board);
  }
}
