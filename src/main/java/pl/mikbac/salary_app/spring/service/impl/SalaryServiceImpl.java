package pl.mikbac.salary_app.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.mikbac.salary_app.exception.ExchangeRateNotFoundException;
import pl.mikbac.salary_app.model.CountryModel;
import pl.mikbac.salary_app.spring.repository.CurrencyRepository;
import pl.mikbac.salary_app.spring.service.SalaryService;
import pl.mikbac.salary_app.spring.service.impl.salary.impl.Salary;
import pl.mikbac.salary_app.spring.service.impl.salary.impl.strategies.SalaryPl;

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
