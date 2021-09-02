package pl.mikbac.salaryapp.spring.facade.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.mikbac.salaryapp.data.impl.CountryData;
import pl.mikbac.salaryapp.spring.converter.Converter;
import pl.mikbac.salaryapp.spring.service.CountryService;
import pl.mikbac.salaryapp.model.CountryModel;
import pl.mikbac.salaryapp.spring.facade.CountryFacade;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MikBac on 25.07.2019
 */

@Log4j2
@Service
public class CountryFacadeImpl implements CountryFacade {

    @Resource
    private CountryService countryService;

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

}
