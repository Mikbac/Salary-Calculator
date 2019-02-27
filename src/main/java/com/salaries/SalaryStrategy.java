package com.salaries;

import java.math.BigDecimal;

public interface SalaryStrategy {

    BigDecimal getExchangeRate(String countryCode);

    BigDecimal calculateSalary(BigDecimal valueFromClient, BigDecimal fixedCosts, BigDecimal tax, String currencyCode);

}
