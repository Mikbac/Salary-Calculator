package pl.MikBac.salaryApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MikBac on 2018
 */

@Controller
public class CountryController {

    @RequestMapping("/country")
    public String country() {
        return "index";
    }
}
