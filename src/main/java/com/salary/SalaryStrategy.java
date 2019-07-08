package com.salary;

import com.model.CountryModel;

import java.math.BigDecimal;

public interface SalaryStrategy {

    BigDecimal getExchangeRate(String countryCode);

    BigDecimal calculateSalary(CountryModel countryModel, String valueFromClient);

}
