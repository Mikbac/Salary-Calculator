/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.MikBac.salaryApp.constants.WebConstants.Mapping;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.facade.CountryFacade;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping(Mapping.SALARY_CALCULATOR)
public class CountryController {

    @Resource
    CountryFacade countryFacade;

    @GetMapping(value = Mapping.COUNTRIES, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CountryModel> allCountries() {

        return countryFacade.getAllCountries();

    }

    @PostMapping(value = Mapping.COUNTRY)
    public ResponseEntity<CountryModel> addCountry(@RequestBody @Valid @NotNull CountryModel country) {

        return countryFacade.addCountry(country);

    }

    @GetMapping(value = Mapping.CALCULATOR, produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getSalary(@PathVariable String countryCode, @PathVariable String valueFromClient) {

        return countryFacade.getSalary(countryCode, valueFromClient);

    }

}
