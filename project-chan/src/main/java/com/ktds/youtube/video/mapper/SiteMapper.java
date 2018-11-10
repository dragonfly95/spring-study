package com.ktds.youtube.video.mapper;

import com.ktds.youtube.video.vo.SiteVO;

import java.util.ArrayList;

public interface SiteMapper {

  // 목록
  public ArrayList<SiteVO> findAll();

  // 1건 조회
  public SiteVO findOne(int siteId);


  // 등록
  public int insert(SiteVO siteVO);



  public int update(SiteVO siteVO);

  public int delete(int siteId);
}
