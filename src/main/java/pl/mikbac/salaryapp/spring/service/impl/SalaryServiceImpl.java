package pl.mikbac.salaryapp.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.mikbac.salaryapp.spring.repository.CurrencyRepository;
import pl.mikbac.salaryapp.spring.service.SalaryService;
import pl.mikbac.salaryapp.spring.service.impl.salary.impl.Salary;
import pl.mikbac.salaryapp.spring.service.impl.salary.impl.strategies.SalaryPl;
import pl.mikbac.salaryapp.exception.ExchangeRateNotFoundException;
import pl.mikbac.salaryapp.model.CountryModel;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by MikBac on 07.09.2019
 */

@Service
public class SalaryServiceImpl implements SalaryService {

    @Resource
    private CurrencyRepository currencyRepository;

    @Override
    public BigDecimal getSalaryPLN(final CountryModel country, final String valueFromClient) {
        final Salary salary = new Salary();
        salary.setStrategy(new SalaryPl());
        return salary.calculateSalary(currencyRepository.getExchangeRate(country.getCurrencyCode())
                .orElseThrow(() -> new ExchangeRateNotFoundException(country.getCurrencyCode())), country, valueFromClient);
    }

}
