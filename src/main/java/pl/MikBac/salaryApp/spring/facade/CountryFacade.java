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

    ResponseEntity<CountryModel> addCountry(CountryModel country);

    BigDecimal getSalary(String countryCode, String valueFromClient);

    void setStrategy(Salary salary, SalaryPl salaryPl);

    BigDecimal calculateSalary(Salary salary, String countryCode, String valueFromClient);
}
