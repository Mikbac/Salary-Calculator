package com.salaries;

import java.math.BigDecimal;

public class Salary {

    private SalaryStrategy strategy;

    public void setStrategy(SalaryStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal getExchangeRate(String countryCode){
       return strategy.getExchangeRate(countryCode);
    }

    public BigDecimal calculateSalary(BigDecimal valueFromClient, BigDecimal fixedCosts, BigDecimal tax, String currencyCode){
        return strategy.calculateSalary(valueFromClient, fixedCosts, tax, currencyCode);
    }
}
