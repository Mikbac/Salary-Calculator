/**
 * Created by MikBac on 25.07.2019
 */

package pl.MikBac.salaryApp.spring.facade;

import org.springframework.http.ResponseEntity;
import pl.MikBac.salaryApp.data.impl.CountryData;
import pl.MikBac.salaryApp.model.CountryModel;

import java.math.BigDecimal;
import java.util.List;

public interface CountryFacade {

    List<CountryData> getAllCountries();

    ResponseEntity<CountryModel> addCountry(final CountryModel country);

    BigDecimal calculateSalary(final String countryCode, final String valueFromClient);
}
