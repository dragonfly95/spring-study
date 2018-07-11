package org.onnuri.springboot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by minah on 2016-08-16.
 */
@Controller
public class HelloController {


    @Autowired
    PostDao postDao;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "spring 3 MVC hello world");
        return "hello";
    }

    @RequestMapping("/post/write")
    public String write(Post post) {
        post.setRegDate(new Date());
        return "redirect:/post/" + postDao.save(post).getId();
    }

    @RequestMapping("/post/list")
    public String list(Model model) {
        List<Post> postList = postDao.findAll();
        model.addAttribute("postList", postList);
        return "blog";
    }

    @RequestMapping("/post/{id}")
    public String view(Model model, @PathVariable int id) {
        Post post = postDao.findOne(id);
        System.out.println(post.getSubject());
        model.addAttribute("post", post);
        return "post";
    }
}


interface PostDao extends JpaRepository<Post, Integer> {

}


@Entity
class Post {
    @Id
    @GeneratedValue
    int id;

    String subject;

    @Column(length = 100000000)
    String content;

    Date regDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }


}