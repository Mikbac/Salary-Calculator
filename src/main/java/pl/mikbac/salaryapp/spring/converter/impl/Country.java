package pl.mikbac.salaryapp.spring.converter.impl;

import org.springframework.stereotype.Service;
import pl.mikbac.salaryapp.data.impl.CountryData;
import pl.mikbac.salaryapp.model.CountryModel;
import pl.mikbac.salaryapp.spring.converter.Converter;

/**
 * Created by MikBac on 07.09.2019
 */

@Service
public class Country implements Converter<CountryData, CountryModel> {
    @Override
    public CountryData convert(CountryModel model) {
        return CountryData.builder()
                .countryCode(model.getCountryCode())
                .currencyCode(model.getCurrencyCode())
                .build();
    }

    @Override
    public CountryModel inverseConvert(CountryData data) {
        return CountryModel.builder()
                .countryCode(data.getCountryCode())
                .currencyCode(data.getCurrencyCode())
                .build();
    }
}
