package com.ktds.youtube.video.vo;

import lombok.Data;

import java.util.Date;

@Data
public class FileDto {

  private int fileNo;     //   파일번호
  private String fileNm;     //   파일명
  private String path;        //   파일경로
  private int boardNo;    //   게시판번호
  private String delYn;      //   삭제여부
  private Date regDt;      //   생성일
  private Date modDt;      //   수정일

}
