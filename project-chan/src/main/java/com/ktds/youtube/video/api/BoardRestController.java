package com.ktds.youtube.video.api;


import com.ktds.youtube.video.mapper.BoardMapper;
import com.ktds.youtube.video.vo.BoardDto;
import com.ktds.youtube.video.web.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {

  @Autowired
  private BoardMapper boardMapper;

  /** 게시물 목록 조회 */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public HashMap list() {
    ArrayList<BoardDto> all = boardMapper.findAll();
    HashMap map = new HashMap();
    map.put("list", all);
    return map;
  }

  /** 게시물 등록  */
  @PostMapping(value = "")
  public ResponseVO insert(@RequestBody BoardDto boardDto) {
    boardMapper.insert(boardDto);
    return new ResponseVO();
  }


  /** 게시물 상세 조회 */
  @RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
  public HashMap findOne(@PathVariable("boardNo") int boardNo) {
    BoardDto boardDto = boardMapper.findOne(boardNo);

    HashMap map = new HashMap();
    map.put("boardDto", boardDto);
    return map;
  }


  /** 게시물 수정  */
  @PutMapping(value = "/{boardNo}")
  public ResponseVO update(@RequestBody BoardDto boardDto) {
    BoardDto boardDto1 = boardMapper.findOne(boardDto.getBoardNo());
    if(boardDto1 == null) return null;

    boardMapper.update(boardDto);
    return new ResponseVO();
  }

  /** 게시물 삭제  */
  @DeleteMapping(value = "/{boardNo}")
  public ResponseVO delete(@PathVariable("boardNo") int boardNo) {
    BoardDto boardDto1 = boardMapper.findOne(boardNo);
    if(boardDto1 == null) return null;

    boardMapper.delete(boardNo);

    return new ResponseVO();
  }
}
