package com.ktds.youtube.video.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MemberDto {

  private int memberNo;   //   회원번호
  private String memberId;   //   회원ID
  private String memberPwd;  //   회원Password
  private String memberNm;   //   회원명
  private String delYn;      //   탈퇴여부
  private Date regDt;      //   생성일
  private Date modDt;      //   수정일

}
