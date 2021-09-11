package pl.mikbac.salary_app.spring.facade;

import org.springframework.http.ResponseEntity;
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
     * @return ResponseEntity of {@link CountryModel}.
     */
    ResponseEntity<CountryModel> addCountry(final CountryModel country);

}
