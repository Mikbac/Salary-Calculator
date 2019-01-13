package restApi.repositories;

import restApi.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CountryRepository extends CrudRepository<Country, Integer>, PagingAndSortingRepository<Country, Integer> {

    Country findByCountryCode(String countryCode);

    boolean existsCountryByCountryCode(String countryCode);
}
