/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.MikBac.salaryApp.model.CountryModel;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<CountryModel, Integer>, PagingAndSortingRepository<CountryModel, Integer> {

    Optional<CountryModel> findByCountryCode(String countryCode);

    Optional<Boolean> existsCountryByCountryCode(String countryCode);
}
