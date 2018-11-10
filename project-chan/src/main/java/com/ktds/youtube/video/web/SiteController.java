package com.ktds.youtube.video.web;

import com.ktds.youtube.video.mapper.SiteMapper;
import com.ktds.youtube.video.vo.SiteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/site")
public class SiteController {

  @Autowired
  private SiteMapper siteMapper;

  @RequestMapping(value = "list.do", method = RequestMethod.GET)
  public String list(Model model) {
    return "site-list";
  }

  //--- api -----------------------------------//
  /**
   * 목록 조회
   * @return
   */
  @RequestMapping(value = "" , method = RequestMethod.GET)
  public ResponseEntity<ArrayList<SiteVO>> findAll() {
    ArrayList list = new ArrayList();
    list = siteMapper.findAll();
    return new ResponseEntity<ArrayList<SiteVO>>(list, HttpStatus.OK);
  }


  /**
   * 등록
   * @param siteVO
   * @return
   */
  @PostMapping(value = "")
  public ResponseEntity<ResponseVO> insert(@RequestBody SiteVO siteVO) {
//    siteVO.getSiteId();
    siteMapper.insert(siteVO);
    return new ResponseEntity(new ResponseVO(), HttpStatus.OK);
  }



  @RequestMapping(value = "/{siteId}")
  public ResponseEntity<SiteVO> findOne(@PathVariable int siteId) {
    SiteVO siteVO = siteMapper.findOne(siteId);
    return new ResponseEntity<SiteVO>(siteVO, HttpStatus.OK);
  }


  // 수정
  @PutMapping(value = "/{siteId}")
  public ResponseEntity<ResponseVO> update(@RequestBody SiteVO siteVO) {
    siteMapper.update(siteVO);
    return new ResponseEntity(new ResponseVO(), HttpStatus.OK);
  }

  // 삭제
  @DeleteMapping(value = "/{siteId}")
  public ResponseEntity<ResponseVO> delete(@PathVariable int siteId) {
    siteMapper.delete(siteId);
    return new ResponseEntity(new ResponseVO(), HttpStatus.OK);
  }
}
