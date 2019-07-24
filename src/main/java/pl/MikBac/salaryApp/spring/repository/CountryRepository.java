/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.MikBac.salaryApp.model.CountryModel;

public interface CountryRepository extends CrudRepository<CountryModel, Integer>, PagingAndSortingRepository<CountryModel, Integer> {

    CountryModel findByCountryCode(String countryCode);

    boolean existsCountryByCountryCode(String countryCode);
}
