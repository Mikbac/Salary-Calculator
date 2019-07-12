package pl.MikBac.salaryApp.repository;

import pl.MikBac.salaryApp.model.CountryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by MikBac on 2018
 */

public interface CountryRepository extends CrudRepository<CountryModel, Integer>, PagingAndSortingRepository<CountryModel, Integer> {

    CountryModel findByCountryCode(String countryCode);

    boolean existsCountryByCountryCode(String countryCode);
}
