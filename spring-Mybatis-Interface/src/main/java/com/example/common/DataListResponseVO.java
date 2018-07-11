package com.example.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DataListResponseVO<T> extends ResponseVO {


  private static final long serialVersionUID = -6448401994102722385L;

  private List<T> list;

  private int pageSize;

  private Integer page;

  private long fullListSize;

  public DataListResponseVO(String resultCode) {
    super(resultCode);
  }

  public DataListResponseVO(List<T> list) {
    this(ResultCodes.OK);
    this.list = list;
  }

  public DataListResponseVO(Page<T> page) {
    this(ResultCodes.OK);
    this.list = page.getContent();
    this.pageSize = page.getSize();
    this.page = page.getNumber() + 1;
    this.fullListSize = page.getTotalElements();
  }

}
