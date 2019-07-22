package pl.MikBac.salaryApp.spring.service;

import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.salary.Salary;
import pl.MikBac.salaryApp.salary.strategies.SalaryPl;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

public interface CountryService {

    Iterable<CountryModel> findAll();

    CountryModel saveCountry(CountryModel countryModel);

    void setStrategy(Salary salary, SalaryPl salaryPl);

    Boolean existsCountryByCountryCode(String countryCode);

    BigDecimal calculateSalary(Salary salary, String countryCode, String valueFromClient);
}
