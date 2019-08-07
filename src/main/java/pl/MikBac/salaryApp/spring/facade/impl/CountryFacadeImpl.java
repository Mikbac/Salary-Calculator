/**
 * Created by MikBac on 25.07.2019
 */

package pl.MikBac.salaryApp.spring.facade.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.MikBac.salaryApp.exception.InvalidCountryIdException;
import pl.MikBac.salaryApp.exception.InvalidNumberFormatException;
import pl.MikBac.salaryApp.exception.InvalidUriException;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.salary.Salary;
import pl.MikBac.salaryApp.salary.strategies.SalaryPl;
import pl.MikBac.salaryApp.spring.facade.CountryFacade;
import pl.MikBac.salaryApp.spring.service.CountryService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Component
public class CountryFacadeImpl implements CountryFacade {

    @Resource
    private CountryService countryService;

    @Override
    public Iterable<CountryModel> getAllCountries() {
        return countryService.getAll();
    }

    @Override
    public ResponseEntity<CountryModel> addCountry(final CountryModel country) {
        countryService.saveCountry(country);
        return ResponseEntity.ok().body(country);
    }

    @Override
    public BigDecimal getSalary(final String countryCode, final String valueFromClient) {
        Salary salary = new Salary();

        setStrategy(salary, new SalaryPl());

        if (!countryService.isExistsCountryByCountryCode(countryCode)) {
            throw new InvalidCountryIdException();
        }
        try {

            return calculateSalary(salary, countryCode, valueFromClient);

        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        } catch (Exception e) {
            throw new InvalidUriException();
        }

    }

    @Override
    public BigDecimal calculateSalary(final Salary salary, final String countryCode, final String valueFromClient) {
        CountryModel countryModel = countryService.findByCountryCode(countryCode);
        return salary.calculateSalary(countryModel, valueFromClient);
    }

    @Override
    public void setStrategy(final Salary salary, final SalaryPl salaryPl) {
        salary.setStrategy(salaryPl);
    }

}
