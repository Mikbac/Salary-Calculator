/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.MikBac.salaryApp.exception.InvalidCountryIdException;
import pl.MikBac.salaryApp.exception.InvalidNumberFormatException;
import pl.MikBac.salaryApp.exception.InvalidUriException;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.salary.Salary;
import pl.MikBac.salaryApp.salary.strategies.SalaryPl;
import pl.MikBac.salaryApp.spring.service.CountryService;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("/salary-calculator")
public class CountryRestController {

    @Resource
    private CountryService countryService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CountryModel> allCountries() {
        return countryService.getAll();
    }

    @RequestMapping(value = "/country", method = RequestMethod.POST)
    public ResponseEntity<CountryModel> addCountry(@RequestBody @Valid @NotNull CountryModel countryModel) {
        countryService.saveCountry(countryModel);
        return ResponseEntity.ok().body(countryModel);
    }

    @RequestMapping(value = "/country/{countryCode}/salary/{valueFromClient}/salaryPLN", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getSalary(@PathVariable String countryCode, @PathVariable String valueFromClient) {

        Salary salary = new Salary();

        countryService.setStrategy(salary, new SalaryPl());

        if (!countryService.isExistsCountryByCountryCode(countryCode)) {
            throw new InvalidCountryIdException();
        }
        try {

            return countryService.calculateSalary(salary, countryCode, valueFromClient);

        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        } catch (Exception e) {
            throw new InvalidUriException();
        }
    }
}
