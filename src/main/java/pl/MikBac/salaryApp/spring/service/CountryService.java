/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service;

import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.salary.Salary;
import pl.MikBac.salaryApp.salary.strategies.SalaryPl;

import java.math.BigDecimal;

public interface CountryService {

    Iterable<CountryModel> getAll();

    CountryModel saveCountry(CountryModel countryModel);

    void setStrategy(Salary salary, SalaryPl salaryPl);

    Boolean isExistsCountryByCountryCode(String countryCode);

    BigDecimal calculateSalary(Salary salary, String countryCode, String valueFromClient);
}
