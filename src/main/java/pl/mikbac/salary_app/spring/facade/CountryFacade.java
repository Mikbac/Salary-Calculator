package pl.mikbac.salary_app.spring.facade;

import pl.mikbac.salary_app.data.impl.CountryData;
import pl.mikbac.salary_app.model.CountryModel;

import java.util.List;

/**
 * Created by MikBac on 25.07.2019
 */

public interface CountryFacade {

    /**
     * Get the list of all countries.
     *
     * @return list of all countries {@link CountryData}.
     */
    List<CountryData> getAllCountries();

    /**
     * Add country.
     *
     * @param country CountryModel.
     * @return object of {@link CountryModel}.
     */
    CountryData addCountry(CountryData country);

    /**
     * Remove country.
     *
     * @param countryId Long of country id.
     */
    void removeCountry(Long countryId);
}
