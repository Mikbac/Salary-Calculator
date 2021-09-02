package pl.mikbac.salaryapp.spring.service.impl.salary;

import pl.mikbac.salaryapp.model.CountryModel;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

public interface SalaryStrategy {

    BigDecimal calculateSalary(final BigDecimal exchangeRate, final CountryModel country, final String valueFromClient);

}
