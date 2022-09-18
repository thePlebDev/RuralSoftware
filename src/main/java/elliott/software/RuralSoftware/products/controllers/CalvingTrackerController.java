package elliott.software.RuralSoftware.products.controllers;

import elliott.software.RuralSoftware.models.Calf;
import elliott.software.RuralSoftware.models.CalfStatus;
import elliott.software.RuralSoftware.products.services.CalfService;
import elliott.software.RuralSoftware.repositories.CalfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products/CalvingTracker")
public class CalvingTrackerController {

    @Autowired
    CalfService calfService;

    @GetMapping
    public String calvingTracker(Model model,Authentication auth){

        List<Calf> calfList = calfService.getAllCalvesByUser(auth.getName());
        //List<Calf> calfList = new ArrayList<>();

        model.addAttribute("calves",calfList);
        model.addAttribute("calf",new Calf());

        return "calvingTracker";
    }

    @PostMapping
    public String calvingTrackerPost(@Valid Calf calf, BindingResult bindingResult, Authentication auth){
           calfService.saveCalf(calf, auth.getName());

        return "redirect:/products/CalvingTracker";
    }
}
