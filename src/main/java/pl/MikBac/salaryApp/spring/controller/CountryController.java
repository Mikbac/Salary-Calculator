/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.MikBac.salaryApp.constants.WebConstants.Mapping;
import pl.MikBac.salaryApp.constants.WebConstants.Views;

@Controller
public class CountryController {

    @GetMapping(value = {Mapping.ROOT})
    public String country() {
        return Views.MAIN;
    }
}
