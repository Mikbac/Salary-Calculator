/**
 * Created by MikBac on 25.07.2019
 */

package pl.MikBac.salaryApp.spring.facade;

import org.springframework.http.ResponseEntity;
import pl.MikBac.salaryApp.data.impl.CountryData;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.facade.impl.salary.Salary;
import pl.MikBac.salaryApp.spring.facade.impl.salary.strategies.SalaryPl;

import java.math.BigDecimal;
import java.util.List;

public interface CountryFacade {

    List<CountryData> getAllCountries();

    ResponseEntity<CountryModel> addCountry(final CountryModel country);

    BigDecimal getSalary(final String countryCode, final String valueFromClient);

    void setStrategy(final Salary salary, final SalaryPl salaryPl);

    BigDecimal calculateSalary(final Salary salary, final String countryCode, final String valueFromClient);
}
