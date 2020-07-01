/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.MikBac.salaryApp.constants.WebConstants.Mapping;
import pl.MikBac.salaryApp.data.impl.CountryData;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.facade.CountryFacade;

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
    private CountryFacade countryFacade;

    @ApiOperation(value = "Get a list of all available countries.")
    @GetMapping(value = Mapping.COUNTRIES, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryData> getCountries() {
        log.info("Getting all countries");
        return countryFacade.getAllCountries();
    }

    @ApiOperation(value = "Calculate the salary.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "countryCode",
                    value = "Country code.",
                    required = true,
                    dataType = "string",
                    paramType = "RequestParam",
                    defaultValue = "UK"),
            @ApiImplicitParam(name = "salary",
                    value = "User hourly rate.",
                    required = true,
                    dataType = "string",
                    paramType = "RequestParam",
                    defaultValue = "99")
    })
    @GetMapping(value = Mapping.CALCULATOR, produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public BigDecimal getSalary(@RequestParam(value = "countryCode", required = true) String countryCode, @RequestParam(value = "salary", required = true) String salaryFromClient) {
        log.info("Counting salary for country code: {} and salary from client: {}", () -> countryCode, () -> salaryFromClient);
        return countryFacade.calculateSalary(countryCode, salaryFromClient);
    }

    @PostMapping(value = Mapping.COUNTRY)
    public ResponseEntity<CountryModel> addCountry(@RequestBody @Valid @NotNull CountryModel country) {
        log.info("Adding new country: {}", () -> country);
        return countryFacade.addCountry(country);
    }

}
