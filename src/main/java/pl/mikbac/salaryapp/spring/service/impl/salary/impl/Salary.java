package pl.mikbac.salaryapp.spring.service.impl.salary.impl;

import pl.mikbac.salaryapp.model.CountryModel;
import pl.mikbac.salaryapp.spring.service.impl.salary.SalaryStrategy;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

public class Salary {

    private SalaryStrategy strategy;

    public void setStrategy(final SalaryStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal calculateSalary(final BigDecimal exchangeRate, final CountryModel countryModel, final String valueFromClient) {
        return strategy.calculateSalary(exchangeRate, countryModel, valueFromClient);
    }

}
