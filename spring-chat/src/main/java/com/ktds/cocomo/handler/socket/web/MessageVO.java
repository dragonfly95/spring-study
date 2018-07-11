package com.ktds.cocomo.handler.socket.web;

import com.google.gson.Gson;

/**
 * Created by minah on 2017-12-09.
 */
public class MessageVO {

  private String message;
  private String type;
  private String to;

  public static MessageVO convertMessage(String source) {
    MessageVO messageVO = new MessageVO();
    Gson gson = new Gson();
    messageVO = gson.fromJson(source, MessageVO.class);
    return messageVO;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }
}
