package pl.mikbac.salary_app.spring.controller.api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mikbac.salary_app.spring.facade.SalaryFacade;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

import static pl.mikbac.salary_app.constants.WebConstants.Mapping;

/**
 * Created by MikBac on 2018
 */

@Log4j2
@CrossOrigin
@RestController
@Validated
@RequestMapping(Mapping.API)
public class SalaryController {

    @Resource
    private SalaryFacade salaryFacade;

    @ApiOperation(value = "Calculate the salary.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "countryCode",
                    value = "Country code.",
                    required = true,
                    dataType = "string",
                    paramType = "RequestParam"),
            @ApiImplicitParam(name = "salary",
                    value = "User hourly rate.",
                    required = true,
                    dataType = "string",
                    paramType = "RequestParam")
    })
    @GetMapping(value = Mapping.CALCULATOR, produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BigDecimal> getSalary(@RequestParam(value = "countryCode") @NotBlank final String countryCode,
                                                @RequestParam(value = "salary") @NotBlank final String salaryFromClient) {
        log.info("Counting salary for country code: {} and salary from client: {}", () -> countryCode, () -> salaryFromClient);
        return ResponseEntity.ok(salaryFacade.calculateSalary(countryCode, salaryFromClient));
    }

}
