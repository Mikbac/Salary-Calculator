/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.MikBac.salaryApp.constants.AttributeConstants.ModelAttributes.HomePage;
import pl.MikBac.salaryApp.constants.WebConstants.Mapping;
import pl.MikBac.salaryApp.constants.WebConstants.Views;
import pl.MikBac.salaryApp.spring.facade.HomePageFacade;

import javax.annotation.Resource;

@Controller
@RequestMapping(Mapping.ROOT)
public class HomePageController {

    @Resource
    private HomePageFacade homePageFacade;

    @GetMapping(value = "")
    public String get(final Model model) {
        model.addAttribute(HomePage.COUNTRIES, homePageFacade.getCoutries());
        return Views.MAIN_PAGE;
    }
}
