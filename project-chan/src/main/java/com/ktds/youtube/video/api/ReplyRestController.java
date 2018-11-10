package com.ktds.youtube.video.api;

import com.ktds.youtube.video.mapper.ReplyMapper;
import com.ktds.youtube.video.vo.ReplyDto;
import com.ktds.youtube.video.web.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/reply")
public class ReplyRestController {

  @Autowired
  private ReplyMapper replyMapper;

  /** 게시물별 댓글 목록 조회 */
  @RequestMapping(value = "/{boardNo}")
  public HashMap findAll(@PathVariable("boardNo") int boardNo) {
    ArrayList<ReplyDto> all = replyMapper.findAll(boardNo);
    HashMap map = new HashMap();
    map.put("list", all);
    return map;
  }


  /** 댓글 등록 */
  @PostMapping(value = "")
  public ResponseVO insert(@RequestBody ReplyDto replyDto) {
    replyMapper.insert(replyDto);
    return new ResponseVO();
  }


  /** 댓글 수정 */
  @PutMapping(value = "/{replyNo}")
  public ResponseVO update(@RequestBody ReplyDto replyDto) {
    replyMapper.update(replyDto);
    return new ResponseVO();
  }


  /** 댓글 상세 삭제 */
  @DeleteMapping(value = "/{boardNo}/{replyNo}")
  public ResponseVO delete(@PathVariable("boardNo") int boardNo,
                           @PathVariable("replyNo") int replyNo) {

    ReplyDto replyDto = new ReplyDto();
    replyDto.setBoardNo(boardNo);
    replyDto.setReplyNo(replyNo);

    replyMapper.delete(replyDto);
    return new ResponseVO();
  }


  /** 게시물별 댓글 전체 삭제 */
  @DeleteMapping(value = "/{boardNo}")
  public ResponseVO deleteAll(@PathVariable("boardNo") int boardNo) {

    replyMapper.deleteAll(boardNo);
    return new ResponseVO();
  }
}
