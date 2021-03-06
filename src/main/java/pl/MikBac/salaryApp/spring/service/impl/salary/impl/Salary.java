/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service.impl.salary.impl;

import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.service.impl.salary.SalaryStrategy;

import java.math.BigDecimal;

public class Salary {

    private SalaryStrategy strategy;

    public void setStrategy(final SalaryStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal calculateSalary(final BigDecimal exchangeRate, final CountryModel countryModel, final String valueFromClient) {
        return strategy.calculateSalary(exchangeRate, countryModel, valueFromClient);
    }

}
