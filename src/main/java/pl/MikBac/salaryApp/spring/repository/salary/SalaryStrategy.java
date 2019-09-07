/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.repository.salary;

import pl.MikBac.salaryApp.model.CountryModel;

import java.math.BigDecimal;

public interface SalaryStrategy {

    BigDecimal getExchangeRate(String countryCode);

    BigDecimal calculateSalary(CountryModel countryModel, String valueFromClient);

}