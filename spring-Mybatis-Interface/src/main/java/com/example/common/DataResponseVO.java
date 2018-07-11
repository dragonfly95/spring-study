package com.example.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponseVO<T> extends ResponseVO {


  private static final long serialVersionUID = -5274103459015990112L;


  @JsonUnwrapped
  private T data;

  public DataResponseVO(String resultCode) {
    super(resultCode);
  }

  public DataResponseVO(T data) {
    this(ResultCodes.OK);
    this.data = data;
  }

}
