package com.ktds.youtube.video.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyDto {

  private int replyNo;    //   댓글번호
  private String content;     // 댓글내용
  private int writer;      //   작성자
  private int boardNo;    //   게시판번호
  private String delYn;      //   삭제여부
  private Date regDt;      //   생성일
  private Date modDt;      //   수정일
}
