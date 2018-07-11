package org.onnuri.ezraiii.repository;

import org.apache.ibatis.annotations.Select;

/**
 * Created by dbdyd on 2016. 12. 29..
 */
public interface UserMapper {
  public String selectList();

  @Select("select now()")
  public String getTime();
}
