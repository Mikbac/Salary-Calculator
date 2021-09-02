package pl.MikBac.salaryApp.spring.facade.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.MikBac.salaryApp.exception.CountryNotFoundException;
import pl.MikBac.salaryApp.spring.facade.SalaryFacade;
import pl.MikBac.salaryApp.spring.service.CountryService;
import pl.MikBac.salaryApp.spring.service.SalaryService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by MikBac on 25.07.2019
 */

@Log4j2
@Service
public class SalaryFacadeImpl implements SalaryFacade {

    @Resource
    private CountryService countryService;

    @Resource
    private SalaryService salaryService;

    @Override
    public BigDecimal calculateSalary(final String countryCode, final String valueFromClient) {
        return salaryService.getSalaryPLN(countryService.getCountryByCode(countryCode)
                .orElseThrow(() -> new CountryNotFoundException(countryCode)), valueFromClient);
    }

}
