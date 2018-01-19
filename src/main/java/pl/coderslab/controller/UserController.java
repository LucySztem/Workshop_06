package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        //odsylamy do folderu user z widokiem register
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "user/register";
        }

        userRepository.save(user);
        //save to seesion
        return"home/index";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @PostMapping("/login")
    public String loging(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request){
        if(email.length()>0 && password.length() > 0){
            User user = userRepository.findByEmail(email);
            if(user != null &&  BCrypt.checkpw(password, user.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                return "redirect:/";
            }
        }
        return "user/login";
    }

}
