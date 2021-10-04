package pl.mikbac.salary_app.constants;

/**
 * Created by MikBac on 03.08.2019
 */

public interface WebConstants {

    interface Mapping {
        String ROOT = "/";
        String API = "/api";
        String COUNTRIES = ROOT + "countries";
        String COUNTRIES_ID = ROOT + "countries/{countryId}";
        String CALCULATOR = ROOT + "salaries/pln";
        String ERROR_PAGE = ROOT + "error";
    }

    interface Views {
        String MAIN_PAGE = "mainPage";
        String ERROR_PAGE = "errorPage";
    }

}
