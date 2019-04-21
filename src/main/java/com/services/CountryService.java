package com.services;

import com.entities.Country;
import com.salaries.Salary;
import com.salaries.strategies.SalaryPl;

import java.math.BigDecimal;

public interface CountryService {

    Iterable<Country> findAll();

    Country saveCountry(Country country);

    void setStrategy(Salary salary, SalaryPl salaryPl);

    Boolean existsCountryByCountryCode(String countryCode);

    BigDecimal calculateSalary(Salary salary, String countryCode, String valueFromClient);
}
