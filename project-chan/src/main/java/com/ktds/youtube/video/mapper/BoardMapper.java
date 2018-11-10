package com.ktds.youtube.video.mapper;

import com.ktds.youtube.video.vo.BoardDto;

import java.util.ArrayList;

public interface BoardMapper {

  /** 게시물 목록 조회 */
  public ArrayList<BoardDto> findAll();

  /** 게시물 상세 조회 */
  public BoardDto findOne(int boardNo);


  /** 게시물 등록  */
  public int insert(BoardDto boardDto);


  /** 게시물 수정  */
  public int update(BoardDto boardDto);


  /** 게시물 삭제  */
  public int delete(int boardNo);

}
