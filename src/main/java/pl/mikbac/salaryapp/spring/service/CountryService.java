package pl.mikbac.salaryapp.spring.service;

import pl.mikbac.salaryapp.model.CountryModel;

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
    void saveCountry(final CountryModel country);

    /**
     * Get country by country code.
     *
     * @param countryCode of selected country.
     * @return optional {@link CountryModel}.
     */
    Optional<CountryModel> getCountryByCode(final String countryCode);

}
