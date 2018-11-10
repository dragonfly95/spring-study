package com.ktds.youtube.video.mapper;

import com.ktds.youtube.video.vo.MemberDto;

import java.util.ArrayList;

public interface MemberMapper {

  /** 회원 정보 조회 */
  public ArrayList<MemberDto> findAll();


  /** 회원 정보 등록 */
  public MemberDto findOne(int boardNo);


  /** 회원 정보 수정 */
  public int insert(MemberDto memberDto);


  /** 회원 정보 수정 */
  public int update(MemberDto memberDto);


  /** 회원 정보 삭제 */
  public int delete(int boardNo);
}
