package restApi.controllers;

import restApi.entities.Country;
import restApi.exchangeRateFromApi.ExchangeRate;
import restApi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "*")
@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = "/country", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Country> allCountries() {
        return countryRepository.findAll();
    }

    @RequestMapping(value = "/country/add", method = RequestMethod.POST)
    public ResponseEntity<Country> addCountry(@RequestBody @Valid @NotNull Country country) {
        countryRepository.save(country);
        return ResponseEntity.ok().body(country);
    }

    @RequestMapping(value = "/country/salary/{countryCode}/{valueFromClient}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public double salary(@PathVariable String countryCode, @PathVariable double valueFromClient) {
        double salary = countryRepository.salary(countryCode, valueFromClient);
        double exchangePLN = ExchangeRate.getExchangeRate(countryRepository.getCurrencyCode(countryCode));
        double salaryPLN = exchangePLN * salary;
        return Math.round(salaryPLN * 100) / 100.0;
    }
}
