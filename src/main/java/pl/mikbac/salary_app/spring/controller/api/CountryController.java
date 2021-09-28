package pl.mikbac.salary_app.spring.controller.api;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mikbac.salary_app.constants.WebConstants.Mapping;
import pl.mikbac.salary_app.data.impl.CountryData;
import pl.mikbac.salary_app.model.CountryModel;
import pl.mikbac.salary_app.spring.facade.CountryFacade;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by MikBac on 2018
 */

@Log4j2
@CrossOrigin
@RestController
@RequestMapping(Mapping.API)
public class CountryController {

    @Resource
    private CountryFacade countryFacade;

    @ApiOperation(value = "Get a list of all available countries.")
    @GetMapping(value = Mapping.COUNTRIES, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryData> getCountries() {
        log.info("Getting all countries");
        return countryFacade.getAllCountries();
    }

    @PostMapping(value = Mapping.COUNTRIES)
    public ResponseEntity<CountryModel> addCountry(@RequestBody @Valid @NotNull final CountryModel country) {
        log.info("Adding new country: {}", () -> country);
        return countryFacade.addCountry(country);
    }

}
