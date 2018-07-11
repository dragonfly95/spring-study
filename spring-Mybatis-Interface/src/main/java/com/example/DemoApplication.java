package com.example;

import com.example.domain.Board;
import com.example.domain.Comment;
import com.example.repository.BoardRepository;
import com.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Autowired
  BoardRepository boardRepository;

  @Autowired
  CommentRepository commentRepository;
 

  @Override
  public void run(String... strings) throws Exception {

    Board b1 = new Board("bbsTitle1","content1","name1");
    Board b2 = new Board("bbsTitle2","content2","name2");
    Board b3 = new Board("bbsTitle3","content3","name3");


    boardRepository.save(b1);
    boardRepository.save(b2);
    boardRepository.save(b3);

    commentRepository.save(new Comment("txt1","dbdyd1",b1));
    commentRepository.save(new Comment("txt11","dbdyd11",b1));

    commentRepository.save(new Comment("txt2","dbdyd2",b2));
    boardRepository.flush();
  }
}
