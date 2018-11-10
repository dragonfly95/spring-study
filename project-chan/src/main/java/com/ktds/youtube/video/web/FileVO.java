package com.ktds.youtube.video.web;


@lombok.Data
public class FileVO {
  private String originFileName;
  private String destFileName;

  @Override
  public String toString() {
    return "FileVO{" +
        "originFileName='" + originFileName + '\'' +
        ", destFileName='" + destFileName + '\'' +
        '}';
  }
}
