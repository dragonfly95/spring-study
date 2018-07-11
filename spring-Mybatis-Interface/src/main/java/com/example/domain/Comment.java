package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by minah on 2016-10-02.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Comment implements Serializable {

  private static final long serialVersionUID = 7805962046045371939L;

  @Id
  @GeneratedValue
  private int cmtId;

  @ManyToOne
  @JoinColumn(name="bbsId")
  private Board board;

  private String cmtText;

  private String userName;

  public Comment() {}

  public Comment(String cmtText, String userName) {
    this.cmtText = cmtText;
    this.userName = userName;
  }

  public Comment(String cmtText, String userName, Board board) {
    this.cmtText = cmtText;
    this.userName = userName;
    this.board = board;
  }

}
