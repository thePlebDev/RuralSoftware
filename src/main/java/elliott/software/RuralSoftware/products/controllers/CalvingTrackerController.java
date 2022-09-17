package elliott.software.RuralSoftware.products.controllers;

import elliott.software.RuralSoftware.models.Calf;
import elliott.software.RuralSoftware.models.CalfStatus;
import elliott.software.RuralSoftware.products.services.CalfService;
import elliott.software.RuralSoftware.repositories.CalfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products/CalvingTracker")
public class CalvingTrackerController {

    @Autowired
    CalfService calfService;

    @GetMapping
    public String calvingTracker(Model model){

        List<Calf> calfList = calfService.getAllCalves();

        model.addAttribute("calves",calfList);

        return "calvingTracker";
    }

    @PostMapping
    public String calvingTrackerPost(String tag){
        System.out.println(tag);
        return "calvingTracker";
    }
}
