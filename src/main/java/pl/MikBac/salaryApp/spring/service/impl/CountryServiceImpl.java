/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.salary.Salary;
import pl.MikBac.salaryApp.salary.strategies.SalaryPl;
import pl.MikBac.salaryApp.spring.repository.CountryRepository;
import pl.MikBac.salaryApp.spring.service.CountryService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class CountryServiceImpl implements CountryService {

    @Resource
    CountryRepository countryRepository;

    @Override
    public Iterable<CountryModel> getAll() {
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
    public Boolean isExistsCountryByCountryCode(String countryCode) {
        return countryRepository.existsCountryByCountryCode(countryCode);
    }

    @Override
    public BigDecimal calculateSalary(Salary salary, String countryCode, String valueFromClient) {
        CountryModel countryModel = countryRepository.findByCountryCode(countryCode);
        return salary.calculateSalary(countryModel, valueFromClient);
    }
}
