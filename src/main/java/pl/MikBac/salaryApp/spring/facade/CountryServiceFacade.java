/**
 * Created by MikBac on 25.07.2019
 */


package pl.MikBac.salaryApp.spring.facade;

import org.springframework.http.ResponseEntity;
import pl.MikBac.salaryApp.model.CountryModel;

import java.math.BigDecimal;


public interface CountryServiceFacade {

    Iterable<CountryModel> getAllCountries();

    ResponseEntity<CountryModel> addCountry(CountryModel country);

    BigDecimal getSalary(String countryCode, String valueFromClient);

}
