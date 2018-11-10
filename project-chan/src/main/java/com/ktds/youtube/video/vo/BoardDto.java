package com.ktds.youtube.video.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BoardDto implements Serializable {


  private int boardNo;   //   게시판번호
  private String title;      //   제목
  private String content;    //   내용
  private int writer;     //   작성자
  private String delYn;     //   삭제여부
  private Date regDt;     //   생성일
  private Date modDt;     //   수정일

}
