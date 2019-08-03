/**
 * Created by MikBac on 03.08.2019
 */

package pl.MikBac.salaryApp.constants;

public interface WebConstants {

    interface Mapping {
        String ROOT = "/";
        String SALARY_CALCULATOR = ROOT + "salary-calculator";
        String COUNTRY = ROOT + "country";
        String COUNTRIES = ROOT + "country";
        String CALCULATOR = ROOT + "/country/{countryCode}/salary/{valueFromClient}/salaryPLN";

    }

    interface Views {
        String MAIN = "index";

    }


}
