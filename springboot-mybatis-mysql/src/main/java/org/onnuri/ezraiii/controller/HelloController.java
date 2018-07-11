package org.onnuri.ezraiii.controller;

import org.onnuri.ezraiii.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dbdyd on 2016. 12. 29..
 */
@Controller
public class HelloController {

  @Autowired
  UserMapper userMapper;

  @RequestMapping("/")
  public String hello(Model model) {
    String time = userMapper.selectList();
//    System.out.println(time);
//    model.addAttribute("name",time);

    model.addAttribute("name", userMapper.getTime());
    return "hello";
  }
}
