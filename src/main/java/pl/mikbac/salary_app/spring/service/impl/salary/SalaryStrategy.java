package pl.mikbac.salary_app.spring.service.impl.salary;

import pl.mikbac.salary_app.model.CountryModel;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

public interface SalaryStrategy {

    /**
     * Calculate the salary for the given parameters.
     *
     * @param exchangeRate    exchange rate for source salary.
     * @param country         source salary country.
     * @param valueFromClient salary from the user.
     * @return salary {@link BigDecimal}.
     */
    BigDecimal calculateSalary(BigDecimal exchangeRate, CountryModel country, String valueFromClient);

}
