package pl.MikBac.salaryApp.spring.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.MikBac.salaryApp.constants.WebConstants.Mapping;
import pl.MikBac.salaryApp.constants.WebConstants.Views;

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
