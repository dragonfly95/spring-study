package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by minah on 2016-09-30.
 */
@Getter
@Setter
@AllArgsConstructor
public class BoardDTO implements Serializable {

  private static final long serialVersionUID = 8510555791700718142L;

  private int bbsId;
  private String bbsTitle;
  private String bbsContent;
  private String bbsAttachFile;
  private String userName;


}
