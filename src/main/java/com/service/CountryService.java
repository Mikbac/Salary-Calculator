package com.service;

import com.model.CountryModel;
import com.salary.Salary;
import com.salary.strategies.SalaryPl;

import java.math.BigDecimal;

public interface CountryService {

    Iterable<CountryModel> findAll();

    CountryModel saveCountry(CountryModel countryModel);

    void setStrategy(Salary salary, SalaryPl salaryPl);

    Boolean existsCountryByCountryCode(String countryCode);

    BigDecimal calculateSalary(Salary salary, String countryCode, String valueFromClient);
}
