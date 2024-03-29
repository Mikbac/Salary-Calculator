package pl.mikbac.salary_app.spring.facade.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.mikbac.salary_app.data.impl.CountryData;
import pl.mikbac.salary_app.model.CountryModel;
import pl.mikbac.salary_app.spring.converter.Converter;
import pl.mikbac.salary_app.spring.facade.CountryFacade;
import pl.mikbac.salary_app.spring.service.CountryService;

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
    public CountryData addCountry(final CountryData country) {
        return countryConverter.convert(countryService.saveCountry(countryConverter.inverseConvert(country)));
    }

    @Override
    public void removeCountry(final Long countryId) {
        countryService.removeCountry(countryId);
    }

}
