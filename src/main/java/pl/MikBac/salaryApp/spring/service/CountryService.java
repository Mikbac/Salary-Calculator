/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service;

import pl.MikBac.salaryApp.model.CountryModel;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<CountryModel> getAll();

    void saveCountry(final CountryModel country);

    Optional<CountryModel> getCountryByCode(final String countryCode);

}
