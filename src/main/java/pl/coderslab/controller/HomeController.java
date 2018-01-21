package pl.coderslab.controller;

import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String home(HttpServletRequest request){

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if(user == null){
            return "redirect:/user/login";
        }

        return "home/login";
    }


}
