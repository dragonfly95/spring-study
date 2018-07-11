package com.example.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by minah on 2016-10-01.
 */
@Getter
@Setter
public class Page<T> {

  private int totalElements;
  private int totalPages;
  private int number;
  private List<T> content;
  private int size;

}
