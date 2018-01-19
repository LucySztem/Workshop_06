package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

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
            return "home/register";
        }

        userRepository.save(user);
        //save to seesion
        return"";
    }

}
