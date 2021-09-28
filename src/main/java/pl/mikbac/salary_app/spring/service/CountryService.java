package pl.mikbac.salary_app.spring.service;

import pl.mikbac.salary_app.model.CountryModel;

import java.util.List;
import java.util.Optional;

/**
 * Created by MikBac on 2018
 */

public interface CountryService {

    /**
     * Get the list of all countries.
     *
     * @return list of all countries {@link CountryModel}.
     */
    List<CountryModel> getAll();

    /**
     * Save the country.
     *
     * @param country to add.
     */
    void saveCountry(CountryModel country);

    /**
     * Get country by country code.
     *
     * @param countryCode of selected country.
     * @return optional {@link CountryModel}.
     */
    Optional<CountryModel> getCountryByCode(String countryCode);

}
