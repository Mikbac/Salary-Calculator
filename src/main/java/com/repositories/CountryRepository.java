package com.repositories;

import com.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


public interface CountryRepository extends CrudRepository<Country, Integer>, PagingAndSortingRepository<Country, Integer> {

    Country findByCountryCode(String countryCode);

    boolean existsCountryByCountryCode(String countryCode);
}
