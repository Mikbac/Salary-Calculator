package restApi.repositories;

import restApi.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;

public interface CountryRepository extends CrudRepository<Country, Integer>, PagingAndSortingRepository<Country, Integer>  {

   @Query("SELECT c.fixedCosts FROM Country c WHERE c.countryCode=?1")
   BigDecimal fixedCosts(String countryCode);

    @Query("SELECT c.tax FROM Country c WHERE c.countryCode=?1")
    BigDecimal tax(String countryCode);

    @Query("SELECT c.currencyCode FROM Country c WHERE c.countryCode=?1")
    String getCurrencyCode(String countryCode);

}
