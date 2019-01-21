package com.controllers;

import com.entities.Country;
import com.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.salaries.SalaryPl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("/country-management/")
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


    @RequestMapping(value = "salary/{countryCode}/{valueFromClient}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String salary(@PathVariable String countryCode, @PathVariable String valueFromClient) {

        if (!countryRepository.existsCountryByCountryCode(countryCode)) {
            return "\"This country code does not exist!\"";
        }

        try {
            Country country = countryRepository.findByCountryCode(countryCode);

            BigDecimal fixedCosts = country.getFixedCosts();
            BigDecimal tax = country.getTax();
            String currencyCode = country.getCurrencyCode();
            return SalaryPl.getPlnSalary(new BigDecimal(valueFromClient), fixedCosts, tax, currencyCode).toString();

        } catch (NumberFormatException e) {
            return "\"Wrong value!\"";
        } catch (Exception e) {
            return "\"Wrong URI!\"";
        }

    }
}
