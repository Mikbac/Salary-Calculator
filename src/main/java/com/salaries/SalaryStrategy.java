package com.salaries;

import com.entities.Country;

import java.math.BigDecimal;

public interface SalaryStrategy {

    BigDecimal getExchangeRate(String countryCode);

    BigDecimal calculateSalary(Country country, String valueFromClient);

}
