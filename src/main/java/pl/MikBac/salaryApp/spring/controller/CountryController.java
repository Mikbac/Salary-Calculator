/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountryController {

    @RequestMapping("/country")
    public String country() {
        return "index";
    }
}
