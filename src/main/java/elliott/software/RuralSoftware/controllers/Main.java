package elliott.software.RuralSoftware.controllers;

import elliott.software.RuralSoftware.models.User;
import elliott.software.RuralSoftware.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Main {

    @Autowired
    UserServices userService;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }
    @GetMapping("/read")
    public String testingAuth(){
        return "read";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(User user){
        userService.createBasicUser(user);
        return "register";
    }

}
