package pl.mikbac.salary_app.spring.service.impl.salary;

import pl.mikbac.salary_app.model.CountryModel;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

public interface SalaryStrategy {

    BigDecimal calculateSalary(final BigDecimal exchangeRate, final CountryModel country, final String valueFromClient);

}
