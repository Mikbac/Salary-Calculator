/**
 * Created by MikBac on 25.07.2019
 */

package pl.MikBac.salaryApp.spring.facade;

import org.springframework.http.ResponseEntity;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.salary.Salary;
import pl.MikBac.salaryApp.salary.strategies.SalaryPl;

import java.math.BigDecimal;

public interface CountryFacade {

    Iterable<CountryModel> getAllCountries();

    ResponseEntity<CountryModel> addCountry(final CountryModel country);

    BigDecimal getSalary(final String countryCode, final String valueFromClient);

    void setStrategy(final Salary salary, final SalaryPl salaryPl);

    BigDecimal calculateSalary(final Salary salary, final String countryCode, final String valueFromClient);
}
