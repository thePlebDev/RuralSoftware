package elliott.software.RuralSoftware.products.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products/CalvingTracker")
public class CalvingTrackerController {

    @GetMapping
    public String calvingTracker(){

        return "calvingTracker";
    }
}