package com.salaries;

import com.entities.Country;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Salary {

    private SalaryStrategy strategy;

    public void setStrategy(SalaryStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal getExchangeRate(String countryCode){
       return strategy.getExchangeRate(countryCode);
    }

    public BigDecimal calculateSalary(Country country, String valueFromClient){
        return strategy.calculateSalary(country, valueFromClient);
    }
}
