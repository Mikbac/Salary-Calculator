/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.controller;

import lombok.extern.log4j.Log4j2;
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
import pl.MikBac.salaryApp.spring.facade.impl.data.CountryData;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping(Mapping.SALARY_CALCULATOR)
public class CountryPageController {

    @Resource
    CountryFacade countryFacade;

    @GetMapping(value = Mapping.COUNTRIES, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryData> allCountries() {
        log.info("Getting all countries");
        return countryFacade.getAllCountries();
    }

    @PostMapping(value = Mapping.COUNTRY)
    public ResponseEntity<CountryModel> addCountry(@RequestBody @Valid @NotNull CountryModel country) {
        log.info("Adding new country: {}", () -> country);
        return countryFacade.addCountry(country);
    }

    @GetMapping(value = Mapping.CALCULATOR, produces = MediaType.ALL_VALUE)
    public BigDecimal getSalary(@PathVariable String countryCode, @PathVariable String salaryFromClient) {
        log.info("Counting salary for country code: {} and salary from client: {}", () -> countryCode, () -> salaryFromClient);
        return countryFacade.getSalary(countryCode, salaryFromClient);
    }

}
