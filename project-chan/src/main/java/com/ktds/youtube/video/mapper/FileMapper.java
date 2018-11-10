package com.ktds.youtube.video.mapper;

import com.ktds.youtube.video.vo.FileDto;

import java.util.ArrayList;

public interface FileMapper {

  /** 게시물별 파일 목록 조회 */
  public ArrayList<FileDto> findAll(int boardNo);


  /** 파일 등록 */
  public int insert(FileDto fileDto);

  /** 파일 수정 */
  public int update(FileDto fileDto);


  /** 파일 상세 삭제 */
  public int delete(FileDto fileDto);


  /** 게시물별 파일 전체 삭제 */
  public int deleteAll(int boardNo);

}
