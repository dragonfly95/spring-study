package com.ktds.youtube.video.web;

import com.ktds.youtube.video.mapper.BoardMapper;
import com.ktds.youtube.video.mapper.ReplyMapper;
import com.ktds.youtube.video.vo.BoardDto;
import com.ktds.youtube.video.vo.ReplyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

  @Autowired
  private BoardMapper boardMapper;

  @Autowired
  private ReplyMapper replyMapper;

  @RequestMapping(value = "/")
  public String boardList(ModelMap modelMap) {
    modelMap.addAttribute("boardList", boardMapper.findAll());
    return "board/list.tiles";
  }

  @RequestMapping(value = "/board/write.do")
  public String boardWrite() {
    return "board/write.tiles";
  }

  @RequestMapping(value = "/board/view.do")
  public String boardView(@RequestParam int boardNo, ModelMap modelMap) {
    BoardDto boardto = boardMapper.findOne(boardNo);
    modelMap.addAttribute("boardDto", boardto);
    modelMap.addAttribute("replyList", replyMapper.findAll(boardNo));
    return "board/view.tiles";
  }

  @RequestMapping(value = "/board/modify.do")
  public String boardModify(@RequestParam int boardNo, ModelMap modelMap) {
    BoardDto boardto = boardMapper.findOne(boardNo);
    modelMap.addAttribute("boardDto", boardto);
    return "board/modify.tiles";
  }


  /////////////////////////////
  @RequestMapping(value = "/member.do")
  public String member(ModelMap modelMap) {
    return "member/mlist.tiles2";
  }
}
