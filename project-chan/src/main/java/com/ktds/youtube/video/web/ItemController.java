package com.ktds.youtube.video.web;

import com.ktds.youtube.video.mapper.ItemMapper;
import com.ktds.youtube.video.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

  @Autowired
  private ItemMapper itemMapper;

  @RequestMapping(value = "/list.do")
    public String list () {
      return "/item-list";
    }

    //--- api --------------------------//

    // 목록 api
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<ItemVO>> findAll() {
      ArrayList<ItemVO> itemVOS = itemMapper.findAll();
      return new ResponseEntity<>(itemVOS, HttpStatus.OK);
    }


    // 등록 api
    @PostMapping(value = "")
    public ResponseEntity<ResponseVO> insert(@RequestBody ItemVO itemVO) {
      itemMapper.insert(itemVO);
      return new ResponseEntity<ResponseVO>(new ResponseVO(), HttpStatus.OK);
    }

    // 1건 api
    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public ResponseEntity<ItemVO> findOne(@PathVariable int itemId) {
      ItemVO itemVO1 = itemMapper.findOne(itemId);
      return new ResponseEntity<ItemVO>(itemVO1, HttpStatus.OK);
    }

    // 수정 api
    @PutMapping(value = "/{itemId}")
    public ResponseEntity<ResponseVO> update(@RequestBody ItemVO itemVO) {
      itemMapper.update(itemVO);
      return new ResponseEntity<ResponseVO>(new ResponseVO(), HttpStatus.OK);
    }

    // 삭제 api
    @DeleteMapping(value = "/{itemId}")
    public ResponseEntity<ResponseVO> delet(@PathVariable int itemId) {
        itemMapper.delete(itemId);
        return new ResponseEntity<ResponseVO>(new ResponseVO(), HttpStatus.OK);
    }
}
