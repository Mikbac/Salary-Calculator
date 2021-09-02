/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.MikBac.salaryApp.model.CountryModel;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends CrudRepository<CountryModel, Integer>, PagingAndSortingRepository<CountryModel, Integer> {

    /**
     * Find country by country code.
     *
     * @param countryCode of selected country.
     * @return optional {@link CountryModel}.
     */
    Optional<CountryModel> findByCountryCode(String countryCode);

    /**
     * Find the list of all countries.
     *
     * @return list of all countries {@link CountryModel}.
     */
    List<CountryModel> findAll();

}
