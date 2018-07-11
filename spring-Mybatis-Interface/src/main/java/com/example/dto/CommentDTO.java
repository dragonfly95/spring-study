package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by minah on 2016-09-30.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO implements Serializable {

  private static final long serialVersionUID = 1762038633750125156L;

  private int cmtId;
  private int bbsId;
  private String cmtText;
  private String userName;

}
