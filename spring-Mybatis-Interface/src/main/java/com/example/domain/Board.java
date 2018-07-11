package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by minah on 2016-10-02.
 */
@Getter
@Setter
@ToString(exclude = { "comment"})
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Board implements Serializable {

  private static final long serialVersionUID = 8655820405757086986L;

  @Id @GeneratedValue
  private int bbsId;

  private String bbsTitle;

  private String bbsContent;

  private String bbsAttachFile;

  private String userName;

  @OneToMany(mappedBy = "board")
  private Set<Comment> comment;

  public Board() {}

  public Board(String bbsTitle, String bbsContent, String userName) {
    this.bbsTitle = bbsTitle;
    this.bbsContent = bbsContent;
    this.userName = userName;
  }


}
