package pl.mikbac.salary_app.spring.converter.impl;

import org.springframework.stereotype.Service;
import pl.mikbac.salary_app.data.impl.CountryData;
import pl.mikbac.salary_app.model.CountryModel;
import pl.mikbac.salary_app.spring.converter.Converter;

/**
 * Created by MikBac on 07.09.2019
 */

@Service
public class CountryConverter implements Converter<CountryData, CountryModel> {
    @Override
    public CountryData convert(CountryModel model) {
        return CountryData.builder()
                .countryCode(model.getCountryCode())
                .tax(model.getTax())
                .currencyCode(model.getCurrencyCode())
                .fixedCosts(model.getFixedCosts())
                .build();
    }

    @Override
    public CountryModel inverseConvert(CountryData data) {
        return CountryModel.builder()
                .countryCode(data.getCountryCode())
                .tax(data.getTax())
                .fixedCosts(data.getFixedCosts())
                .currencyCode(data.getCurrencyCode())
                .build();
    }
}
