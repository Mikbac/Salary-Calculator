package pl.mikbac.salaryapp.spring.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mikbac.salaryapp.constants.WebConstants.Mapping;
import pl.mikbac.salaryapp.constants.WebConstants.Views;

/**
 * Created by MikBac on 19.08.2019
 */

@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping(Mapping.ERROR_PAGE)
    public String handleError() {
        return Views.ERROR_PAGE;
    }

    @Override
    public String getErrorPath() {
        return Mapping.ERROR_PAGE;
    }
}
