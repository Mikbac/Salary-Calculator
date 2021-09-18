package pl.mikbac.salary_app.constants;

/**
 * Created by MikBac on 03.08.2019
 */

public interface WebConstants {

    interface Mapping {
        String ROOT = "/";
        String API = "/api";
        String COUNTRIES = ROOT + "countries";
        String CALCULATOR = ROOT + "salaries/pln";
        String ERROR_PAGE = ROOT + "error";
    }

    interface Views {
        String MAIN_PAGE = "mainPage";
        String ERROR_PAGE = "errorPage";
    }

    interface AntPatterns {
        String ROOT = "/";
        String RESOURCES = "/resources/**";
        String ASSETS = "/assets/**";
        String CSS = "/static/css/**";
        String LESS = "/static/less/**";
        String JS = "/static/js/**";
        String IMAGES = "/static/img/**";
        String FONTS = "/fonts/**";
        String JSON = "/static/json/**";
    }

}
