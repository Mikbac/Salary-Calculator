package pl.MikBac.salaryApp.spring.service;

import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.repository.CountryRepository;
import pl.MikBac.salaryApp.salary.Salary;
import pl.MikBac.salaryApp.salary.strategies.SalaryPl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

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
