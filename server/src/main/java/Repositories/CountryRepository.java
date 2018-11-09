package Repositories;

import Entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends CrudRepository<Country, Integer>, PagingAndSortingRepository<Country, Integer>  {

    @Query("SELECT (((?2*22)-((?2*22)*c.tax))-c.fixedCosts)*c.exchangeRate FROM Country c")
    double earnings(String code, double valueFromClient);

}
