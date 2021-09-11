package pl.mikbac.salary_app.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mikbac.salary_app.constants.AttributeConstants.ModelAttributes.HomePage;
import pl.mikbac.salary_app.constants.WebConstants.Mapping;
import pl.mikbac.salary_app.constants.WebConstants.Views;
import pl.mikbac.salary_app.data.impl.CountryData;
import pl.mikbac.salary_app.spring.facade.CountryFacade;

import javax.annotation.Resource;
import java.util.List;

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
        return Views.MAIN_PAGE;
    }

    @PostMapping
    public String setLanguage(final Model model) {
        return Views.MAIN_PAGE;
    }

    @ModelAttribute(HomePage.COUNTRIES)
    private List<CountryData> populateModel() {
        return countryFacade.getAllCountries();
    }

}
