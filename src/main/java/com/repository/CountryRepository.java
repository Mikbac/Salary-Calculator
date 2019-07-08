package com.repository;

import com.model.CountryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CountryRepository extends CrudRepository<CountryModel, Integer>, PagingAndSortingRepository<CountryModel, Integer> {

    CountryModel findByCountryCode(String countryCode);

    boolean existsCountryByCountryCode(String countryCode);
}
