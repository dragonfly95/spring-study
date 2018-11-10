package com.ktds.youtube.video.mapper;

import com.ktds.youtube.video.vo.ItemVO;
import com.ktds.youtube.video.vo.SiteVO;

import java.util.ArrayList;

public interface ItemMapper {

  // 목록
  public ArrayList<ItemVO> findAll();

  // 1건 조회
  public ItemVO findOne(int itemId);


  // 등록
  public int insert(ItemVO itemVO);



  public int update(ItemVO itemId);

  public int delete(int itemId);
}
