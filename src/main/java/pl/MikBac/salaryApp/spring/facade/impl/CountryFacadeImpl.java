/**
 * Created by MikBac on 25.07.2019
 */

package pl.MikBac.salaryApp.spring.facade.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.MikBac.salaryApp.data.impl.CountryData;
import pl.MikBac.salaryApp.exception.CountryNotFoundException;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.converter.Converter;
import pl.MikBac.salaryApp.spring.facade.CountryFacade;
import pl.MikBac.salaryApp.spring.service.CountryService;
import pl.MikBac.salaryApp.spring.service.SalaryService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Component
public class CountryFacadeImpl implements CountryFacade {

    @Resource
    private CountryService countryService;
    @Resource
    private SalaryService salaryService;
    @Resource
    private Converter<CountryData, CountryModel> countryConverter;

    @Override
    public List<CountryData> getAllCountries() {
        return countryService.getAll().stream()
                .map(c -> countryConverter.convert(c))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<CountryModel> addCountry(final CountryModel country) {
        countryService.saveCountry(country);
        return ResponseEntity.ok().body(country);
    }

    @Override
    public BigDecimal calculateSalary(final String countryCode, final String valueFromClient) {
        CountryModel country = countryService.findByCountryCode(countryCode)
                .orElseThrow(() -> new CountryNotFoundException(countryCode));
        return salaryService.getSalaryPLN(country, valueFromClient);
    }

}
