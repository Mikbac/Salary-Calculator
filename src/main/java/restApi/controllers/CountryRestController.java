package restApi.controllers;

import restApi.entities.Country;
import restApi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import restApi.salaries.SalaryPl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;


@RestController
public class CountryRestController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = "/country/getAllCountry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Country> allCountries() {
        return countryRepository.findAll();
    }

    @RequestMapping(value = "/country/addCountry", method = RequestMethod.POST)
    public ResponseEntity<Country> addCountry(@RequestBody @Valid @NotNull Country country) {
        countryRepository.save(country);
        return ResponseEntity.ok().body(country);
    }

    @RequestMapping(value = "/country/salary/{countryCode}/{valueFromClient}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BigDecimal salary(@PathVariable String countryCode, @PathVariable BigDecimal valueFromClient) {

        BigDecimal fixedCosts = countryRepository.fixedCosts(countryCode);
        BigDecimal tax = countryRepository.tax(countryCode);
        String currencyCode = countryRepository.getCurrencyCode(countryCode);

        return SalaryPl.getPlnSalary(valueFromClient, fixedCosts, tax, currencyCode);
    }
}
