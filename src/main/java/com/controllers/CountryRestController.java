package com.controllers;

import com.entities.Country;
import com.exception.InvalidCountryIdException;
import com.exception.InvalidNumberFormatException;
import com.exception.InvalidUriException;
import com.repositories.CountryRepository;
import com.salaries.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.salaries.salary.SalaryPl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("/salary-calculator/")
public class CountryRestController {

    private CountryRepository countryRepository;

    @Autowired
    public CountryRestController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @RequestMapping(value = "countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Country> allCountries() {
        return countryRepository.findAll();
    }

    @RequestMapping(value = "country", method = RequestMethod.POST)
    public ResponseEntity<Country> addCountry(@RequestBody @Valid @NotNull Country country) {
        countryRepository.save(country);
        return ResponseEntity.ok().body(country);
    }


    @RequestMapping(value = "country/{countryCode}/salary/{valueFromClient}/salaryPLN", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal salary(@PathVariable String countryCode, @PathVariable String valueFromClient) {

        Salary salary = new Salary();
        salary.setStrategy(new SalaryPl());

        if (!countryRepository.existsCountryByCountryCode(countryCode)) {
            throw new InvalidCountryIdException();
        }

        try {
            Country country = countryRepository.findByCountryCode(countryCode);

            BigDecimal fixedCosts = country.getFixedCosts();
            BigDecimal tax = country.getTax();
            String currencyCode = country.getCurrencyCode();
            return salary.calculateSalary(new BigDecimal(valueFromClient), fixedCosts, tax, currencyCode);

        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        } catch (Exception e) {
            throw new InvalidUriException();
        }

    }
}
