package com.service;

import com.model.CountryModel;
import com.repository.CountryRepository;
import com.salary.Salary;
import com.salary.strategies.SalaryPl;
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
    public Iterable<CountryModel> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public CountryModel saveCountry(CountryModel countryModel) {
        return countryRepository.save(countryModel);
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
        CountryModel countryModel = countryRepository.findByCountryCode(countryCode);
        return salary.calculateSalary(countryModel, valueFromClient);
    }
}
