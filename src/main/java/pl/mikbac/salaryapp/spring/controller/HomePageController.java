package pl.mikbac.salaryapp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mikbac.salaryapp.constants.AttributeConstants.ModelAttributes.HomePage;
import pl.mikbac.salaryapp.constants.WebConstants.Mapping;
import pl.mikbac.salaryapp.constants.WebConstants.Views;
import pl.mikbac.salaryapp.spring.facade.CountryFacade;

import javax.annotation.Resource;

/**
 * Created by MikBac on 2018
 */

@Controller
@RequestMapping(Mapping.ROOT)
public class HomePageController {

    @Resource
    private CountryFacade countryFacade;

    @GetMapping
    public String get(final Model model) {
        populateModel(model);

        return Views.MAIN_PAGE;
    }

    @PostMapping
    public String setLanguage(final Model model) {
        populateModel(model);

        return Views.MAIN_PAGE;
    }

    private void populateModel(final Model model) {
        model.addAttribute(HomePage.COUNTRIES, countryFacade.getAllCountries());
    }

}
