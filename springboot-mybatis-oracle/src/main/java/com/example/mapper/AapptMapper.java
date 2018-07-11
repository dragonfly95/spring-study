package com.example.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Created by onnuricis on 2016. 12. 30..
 */
public interface AapptMapper {
  @Select("select sysdate from dual")
  public String getTime();
}
