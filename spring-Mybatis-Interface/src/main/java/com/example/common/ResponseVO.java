package com.example.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(value = Include.ALWAYS)
public class ResponseVO implements Serializable {


  private static final long serialVersionUID = 753883434985241507L;

  private String resultCode;

  private String message;

  public ResponseVO(String resultCode) {
    this.resultCode = resultCode;
  }

  public ResponseVO(String resultCode, String message) {
    this.resultCode = resultCode;
    this.message = message;
  }

  public static ResponseVO ok() {
    return new ResponseVO(ResultCodes.OK);
  }

}
