package com.ktds.youtube.video.mapper;

import com.ktds.youtube.video.vo.ReplyDto;

import java.util.ArrayList;

public interface ReplyMapper {

  /** 게시물별 댓글 목록 조회 */
  public ArrayList<ReplyDto> findAll(int boardNo);


  /** 댓글 등록 */
  public int insert(ReplyDto replyDto);


  /** 댓글 수정 */
  public int update(ReplyDto replyDto);


  /** 댓글 상세 삭제 */
  public int delete(ReplyDto replyDto);


  /** 게시물별 댓글 전체 삭제 */
  public int deleteAll(int boardNo);
}
