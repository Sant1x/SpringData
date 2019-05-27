package com.example.demo;

import com.example.demo.model.Hobby;
import com.example.demo.model.Post;
import com.example.demo.model.PostComment;
import com.example.demo.model.SportUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;




    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("users",userService.findUserBySipmleId(2L));
        Post post = new Post("First post");

        post.addComment(
                new PostComment("My first review")
        );
        post.addComment(
                new PostComment("My second review")
        );
        post.addComment(
                new PostComment("My third review")
        );

        userService.savePost(post);


        SportUser sportUser = new SportUser("Nikita");

        sportUser.setHobbies(new Hobby("football"));
        sportUser.setHobbies( new Hobby("basketball"));

        userService.saveSportUser(sportUser);


        List<SportUser> userS = userService.sportUsersList();
        SportUser user = userS.get(0);

        List<Hobby> hobbies = user.getHobbies();
        for (Hobby h : hobbies){
            System.out.println(h.getNamehobby());
        }

        return "home";
    }
}
