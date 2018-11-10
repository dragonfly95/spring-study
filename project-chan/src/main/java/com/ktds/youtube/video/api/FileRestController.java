package com.ktds.youtube.video.api;

import com.ktds.youtube.video.mapper.FileMapper;
import com.ktds.youtube.video.vo.FileDto;
import com.ktds.youtube.video.web.FileVO;
import com.ktds.youtube.video.web.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@PropertySource("classpath:config.properties")
@Controller
@RequestMapping(value = "/api/file")
public class FileRestController {

  @Value("${uploadPath}")
  private String uploadPath;

  @Autowired
  private FileMapper fileMapper;

  /** 게시물별 파일 목록 조회 */
  @RequestMapping
  public ArrayList<FileDto> findAll(int boardNo) {
    ArrayList<FileDto> all = fileMapper.findAll(boardNo);
    return all;
  }


  /** 파일 등록 */
  @PostMapping(value = "/")
  public ResponseVO insert(FileDto fileDto) {
    return new ResponseVO();
  }

  /** 파일 수정 */
  @PutMapping(value = "/{fileNo}")
  public ResponseVO update(FileDto fileDto) {
    return new ResponseVO();
  }

  /** 파일 상세 삭제 */
  @DeleteMapping(value = "/{fileNo}/{fileNo}")
  public ResponseVO delete(FileDto fileDto) {
    return new ResponseVO();
  }


  /** 게시물별 파일 전체 삭제 */
  @DeleteMapping(value = "/{fileNo}")
  public ResponseVO deleteAll(int boardNo) {
    return new ResponseVO();
  }


  @PostMapping(value = "/upload.do")
  public ResponseEntity<FileVO> upload(@ModelAttribute MultipartFile imagePath) {

    FileVO fileVO = new FileVO();

    if (!imagePath.isEmpty()) {
      File uploadDir = new File(uploadPath);
      if (!uploadDir.exists()) {
        uploadDir.mkdir();
        System.out.println("mkdir uploadPath");
      }
      String viewFileName = UUID.randomUUID().toString();
      File videoFile = new File(uploadPath, viewFileName);

      try {
        imagePath.transferTo(videoFile);

        fileVO.setDestFileName(viewFileName);
      } catch (IllegalStateException | IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }
    return new ResponseEntity<FileVO>(fileVO, HttpStatus.OK);
  }
}
