package com.example;


import com.example.mapper.AapptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

  @Autowired
  AapptMapper aapptMapper;

  @RequestMapping("/")
  public String hello() {
    String time = aapptMapper.getTime();
    System.out.print("time >> " + time);
    return "hello";
  }
}
