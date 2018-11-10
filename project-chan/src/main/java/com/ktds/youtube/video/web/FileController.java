package com.ktds.youtube.video.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@PropertySource("classpath:config.properties")
@Controller
@RequestMapping(value = "/file")
public class FileController {



  @Value("${uploadPath}")
  private String uploadPath;


  // download

  // delete file

  // upload
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
