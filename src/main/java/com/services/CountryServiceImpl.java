package com.services;

import com.entities.Country;
import com.repositories.CountryRepository;
import com.salaries.Salary;
import com.salaries.strategies.SalaryPl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CountryServiceImpl implements CountryService {

    CountryRepository countryRepository;


    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void setStrategy(Salary salary, SalaryPl salaryPl) {
        salary.setStrategy(salaryPl);
    }

    @Override
    public Boolean existsCountryByCountryCode(String countryCode) {
        return countryRepository.existsCountryByCountryCode(countryCode);
    }

    @Override
    public BigDecimal calculateSalary(Salary salary, String countryCode, String valueFromClient) {
        Country country = countryRepository.findByCountryCode(countryCode);
        return salary.calculateSalary(country, valueFromClient);
    }
}
