package com.salary;

import com.model.CountryModel;
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

    public BigDecimal calculateSalary(CountryModel countryModel, String valueFromClient){
        return strategy.calculateSalary(countryModel, valueFromClient);
    }
}
