package pl.MikBac.salaryApp.salary;

import pl.MikBac.salaryApp.model.CountryModel;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

public interface SalaryStrategy {

    BigDecimal getExchangeRate(String countryCode);

    BigDecimal calculateSalary(CountryModel countryModel, String valueFromClient);

}
