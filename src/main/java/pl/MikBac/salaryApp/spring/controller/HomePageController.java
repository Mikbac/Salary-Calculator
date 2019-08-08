/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.MikBac.salaryApp.constants.WebConstants.Mapping;
import pl.MikBac.salaryApp.constants.WebConstants.Views;

@Controller
@RequestMapping(Mapping.ROOT)
public class HomePageController {

    @GetMapping(value = "")
    public String get() {
        return Views.MAIN_PAGE;
    }
}
