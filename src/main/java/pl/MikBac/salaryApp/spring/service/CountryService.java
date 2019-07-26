/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service;

import pl.MikBac.salaryApp.model.CountryModel;

public interface CountryService {

    Iterable<CountryModel> getAll();

    CountryModel saveCountry(CountryModel countryModel);

    Boolean isExistsCountryByCountryCode(String countryCode);

    CountryModel findByCountryCode(String countryCode);

}
