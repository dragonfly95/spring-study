package com.ktds.youtube.video.api;

import com.ktds.youtube.video.mapper.MemberMapper;
import com.ktds.youtube.video.vo.MemberDto;
import com.ktds.youtube.video.web.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

  @Autowired
  private MemberMapper memberMapper;

  /** 회원 정보 조회 */
  @RequestMapping
  public ArrayList<MemberDto> findAll() {
    return memberMapper.findAll();
  }


  /** 회원 정보 조회 */
  @PostMapping(value = "/{boardNo}")
  public MemberDto findOne(@PathVariable("boardNo") int boardNo) {
    return memberMapper.findOne(boardNo);
  }


  /** 회원 정보 등록  */
  @PostMapping(value = "/")
  public ResponseVO insert(@RequestBody MemberDto memberDto) {
    MemberDto one = memberMapper.findOne(memberDto.getMemberNo());
    if(one != null) return null;
    memberMapper.insert(memberDto);
    return new ResponseVO();
  }


  /** 회원 정보 수정 */
  @PutMapping(value = "/{memberNo}")
  public ResponseVO update(@RequestBody MemberDto memberDto) {
    MemberDto one = memberMapper.findOne(memberDto.getMemberNo());
    if(one == null) return null;
    memberMapper.update(memberDto);
    return new ResponseVO();
  }


  /** 회원 정보 삭제 */
  public ResponseVO delete(int boardNo) {
    MemberDto one = memberMapper.findOne(boardNo);
    if(one == null) return null;
    memberMapper.delete(boardNo);
    return new ResponseVO();
  }
}
