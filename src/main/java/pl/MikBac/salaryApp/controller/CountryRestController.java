package pl.MikBac.salaryApp.controller;

import pl.MikBac.salaryApp.exception.InvalidNumberFormatException;
import pl.MikBac.salaryApp.exception.InvalidUriException;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.service.CountryService;
import pl.MikBac.salaryApp.exception.InvalidCountryIdException;
import pl.MikBac.salaryApp.salary.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import pl.MikBac.salaryApp.salary.strategies.SalaryPl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

@CrossOrigin
@RestController
@RequestMapping("/salary-calculator")
public class CountryRestController {

    private CountryService countryService;

    @Autowired
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }


    @RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CountryModel> allCountries() {
        return countryService.findAll();
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

        if (!countryService.existsCountryByCountryCode(countryCode)) {
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
