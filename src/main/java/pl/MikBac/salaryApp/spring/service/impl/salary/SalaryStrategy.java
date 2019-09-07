/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service.impl.salary;

import pl.MikBac.salaryApp.model.CountryModel;

import java.math.BigDecimal;

public interface SalaryStrategy {

    BigDecimal calculateSalary(final BigDecimal exchangeRate, final CountryModel country, final String valueFromClient);

}
