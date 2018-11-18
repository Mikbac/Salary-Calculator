package restApi.repositories;

import restApi.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends CrudRepository<Country, Integer>, PagingAndSortingRepository<Country, Integer>  {

    @Query("SELECT (?2*22.00-c.fixedCosts)-((?2*22.00-c.fixedCosts)*c.tax/100.00) FROM Country c WHERE c.countryCode=?1")
    double salary(String countryCode, double valueFromClient);

    @Query("SELECT c.currencyCode FROM Country c WHERE c.countryCode=?1")
    String getCurrencyCode(String countryCode);

}
