package restApi.repositories;

import restApi.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer>, PagingAndSortingRepository<Country, Integer>  {

    Country findByCountryCode(String countryCode);

}
