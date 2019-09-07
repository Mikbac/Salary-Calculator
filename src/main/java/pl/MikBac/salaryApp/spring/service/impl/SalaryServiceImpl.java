/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.MikBac.salaryApp.exception.ExchangeRateNotFoundException;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.repository.CurrencyRepository;
import pl.MikBac.salaryApp.spring.service.SalaryService;
import pl.MikBac.salaryApp.spring.service.impl.salary.impl.Salary;
import pl.MikBac.salaryApp.spring.service.impl.salary.impl.strategies.SalaryPl;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Resource
    private CurrencyRepository currencyRepository;

    @Override
    public BigDecimal getSalaryPLN(final CountryModel country, final String valueFromClient) {
        Salary salary = new Salary();
        salary.setStrategy(new SalaryPl());
        return salary.calculateSalary(currencyRepository.getExchangeRate(country.getCurrencyCode())
                .orElseThrow(() -> new ExchangeRateNotFoundException(country.getCurrencyCode())), country, valueFromClient);
    }

}
