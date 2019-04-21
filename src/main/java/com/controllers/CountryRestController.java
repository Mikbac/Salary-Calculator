package com.controllers;

import com.exception.InvalidNumberFormatException;
import com.exception.InvalidUriException;
import com.services.CountryService;
import com.entities.Country;
import com.exception.InvalidCountryIdException;
import com.salaries.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.salaries.strategies.SalaryPl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
    public Iterable<Country> allCountries() {
        return countryService.findAll();
    }

    @RequestMapping(value = "/country", method = RequestMethod.POST)
    public ResponseEntity<Country> addCountry(@RequestBody @Valid @NotNull Country country) {
        countryService.saveCountry(country);
        return ResponseEntity.ok().body(country);
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
