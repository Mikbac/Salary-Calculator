/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.repository.salary;

import pl.MikBac.salaryApp.model.CountryModel;

import java.math.BigDecimal;

public interface SalaryRepository {

    void setStrategy(final SalaryStrategy strategy);

    BigDecimal getExchangeRate(final String countryCode);

    BigDecimal calculateSalary(final CountryModel countryModel, final String valueFromClient);
}
