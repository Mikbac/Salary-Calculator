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
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.facade.CountryFacade;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("/salary-calculator")
public class CountryRestController {

    @Resource
    CountryFacade countryFacade;

    @RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CountryModel> allCountries() {

        return countryFacade.getAllCountries();

    }

    @RequestMapping(value = "/country", method = RequestMethod.POST)
    public ResponseEntity<CountryModel> addCountry(@RequestBody @Valid @NotNull CountryModel country) {

        return countryFacade.addCountry(country);

    }

    @RequestMapping(value = "/country/{countryCode}/salary/{valueFromClient}/salaryPLN", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getSalary(@PathVariable String countryCode, @PathVariable String valueFromClient) {

        return countryFacade.getSalary(countryCode, valueFromClient);

    }

}
