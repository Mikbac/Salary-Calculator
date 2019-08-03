/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service;

import pl.MikBac.salaryApp.model.CountryModel;

public interface CountryService {

    Iterable<CountryModel> getAll();

    CountryModel saveCountry(final CountryModel countryModel);

    Boolean isExistsCountryByCountryCode(final String countryCode);

    CountryModel findByCountryCode(final String countryCode);

}
